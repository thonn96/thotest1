package com.example.infocity.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;

public class HandleDataCity {
    private LoadDataCityListener listener;
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    public static final String n_country = "country";
    public static final String n_city = "city";
    public static final String n_population = "population";


    public HandleDataCity(LoadDataCityListener listener,Context context) {
        this.listener = listener;
        this.openHelper = new DatabaseOpenHelper(context);
    }
    public HandleDataCity(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }


    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    public void createListCityData() {
        ArrayList<Cities> citiesList = new ArrayList<>();
        Cursor res = database.rawQuery("SELECT * FROM cities", null);
        if (res.moveToFirst()) {
            while (!res.isAfterLast()) {
                String name_country = res.getString(res.getColumnIndex(n_country));
                String name_city = res.getString(res.getColumnIndex(n_city));
                String population = res.getString(res.getColumnIndex(n_population));
                Cities newCities = new Cities(name_country, name_city, population);
                citiesList.add(newCities);
                res.moveToNext();
            }
        }
        listener.onLoadDataCitySuccess(citiesList);
    }


}

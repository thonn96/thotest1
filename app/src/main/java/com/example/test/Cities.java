package com.example.infocity.Model;

public class Cities {
    private String name_country;
    private String name_city;
    private String population;
    public Cities(String name_country, String name_city, String population) {
        this.name_country = name_country;
        this.name_city = name_city;
        this.population = population;
    }

    public String getNameCountry() {
        return this.name_country;
    }

    public String getNameCity() {
        return this.name_city;
    }

    public String getPopulation() {
        return this.population;
    }
}

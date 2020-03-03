package com.autohero.models;

import java.util.List;

public class Location {

    private List<String> countries = null;
    private List<Object> locations = null;

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<Object> getLocations() {
        return locations;
    }

    public void setLocations(List<Object> locations) {
        this.locations = locations;
    }

}


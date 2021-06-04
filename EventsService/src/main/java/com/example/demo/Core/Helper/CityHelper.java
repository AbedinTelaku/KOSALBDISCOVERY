package com.example.demo.Core.Helper;

import com.example.demo.Core.Entities.City;

import java.io.Serializable;
import java.util.List;

public class CityHelper implements Serializable {
      private List<String> cities;

    public CityHelper(List<String> cities) {
        this.cities = cities;
    }

    public CityHelper() {
    }

    public List<String> getCitiesNames() {
        return cities;
    }
}

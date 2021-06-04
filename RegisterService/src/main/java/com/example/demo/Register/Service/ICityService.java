package com.example.demo.Register.Service;

import com.example.demo.Register.Models.City;

import java.util.List;

public interface ICityService {

    void createCity(String name, String zipCode);
    void deleteCity(int id);
    City getCity(String name);
    City getCity(int id);
    List<City> getAllCities();

}

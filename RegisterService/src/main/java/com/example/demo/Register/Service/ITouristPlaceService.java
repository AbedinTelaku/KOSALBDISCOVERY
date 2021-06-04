package com.example.demo.Register.Service;

import com.example.demo.Register.Models.City;
import com.example.demo.Register.Models.TouristPlace;

import java.util.List;

public interface ITouristPlaceService {

    void createTouristPlace(String name, City city);
    void deleteTouristPlace(int id);
    TouristPlace getToruistPlace(int id);
    List<TouristPlace> getAllTouristPlaces();
}

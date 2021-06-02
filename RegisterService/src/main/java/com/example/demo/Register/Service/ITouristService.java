package com.example.demo.Register.Service;


import com.example.demo.Register.Models.Tourist;

import java.util.List;

public interface ITouristService {
    Tourist getTourist(int id);

    Tourist getTouristByUsernameAndPassword(String username, String password);

    List<Tourist> getAllTourists();

    void createTourist(String name, String surname, int age, char gender, String Email, String password, String username, String role);

    void deleteTourist(int id);

    long getTouristsNumber();

}

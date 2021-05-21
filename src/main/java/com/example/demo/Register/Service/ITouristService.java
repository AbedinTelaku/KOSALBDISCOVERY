package com.example.demo.Register.Service;

import com.example.demo.Register.Models.Tourist;

public interface ITouristService {
    void createTourist(Tourist tourist);
    void deleteTourist(int Id);
    void editTourist(int id);
    Tourist login(String username,String password);
}

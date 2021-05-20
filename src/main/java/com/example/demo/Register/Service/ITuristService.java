package com.example.demo.Register.Service;

import com.example.demo.Register.Models.Turist;

public interface IBusinessService {
    void createTurist(Turist turist);
    void deleteTurist(int Id);
    void editTurist(int id);
}

package com.example.demo.Register.Service;


import com.example.demo.Register.Models.Tourist;

import com.example.demo.Register.Repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristService implements ITouristService {

    @Autowired
    private TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    @Override
    public Tourist getTourist(int id) {
        Optional<Tourist> touristObtional = this.touristRepository.findById(id);
        return touristObtional.get();
    }

    @Override
    public Tourist getTouristByUsernameAndPassword(String username, String password) {
        Optional<Tourist> touristOptional = this.touristRepository.findTouristByUsernameAndPassword(username, password);
        return touristOptional.get();
    }

    @Override
    public List<Tourist> getAllTourists() {
        return this.touristRepository.findAll();
    }

    @Override
    public void createTourist(String name, String surname, int age, char gender, String Email, String password, String username, String role) {
        Tourist tourist = new Tourist(name, surname, age, gender, Email, password, username, role);
        this.touristRepository.save(tourist);
    }


    @Override
    public void deleteTourist(int id) {
        this.touristRepository.deleteById(id);

    }

    @Override
    public long getTouristsNumber() {
        return this.touristRepository.count();
    }
}
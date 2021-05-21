package com.example.demo.Register.Service;

import com.example.demo.Register.Models.Tourist;
import com.example.demo.Register.Repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TouristService implements ITouristService{

@Autowired
private TouristRepository touristRepository;


    @Override
    public void createTourist(Tourist tourist) {

    }

    @Override
    public void deleteTourist(int id) {
    this.touristRepository.deleteById(id);
    }

    @Override
    public void editTourist(int id) {

    }

    @Override
    public Tourist login(String username, String pass) {
        Optional<Tourist> touristOptional=this.touristRepository.findTouristByUsernameAndPassword(username,pass);

        if(touristOptional.isEmpty()){
            return null;
        }
        return touristOptional.get();
    }
}
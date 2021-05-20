package com.example.demo.Register.Service;

import com.example.demo.Register.Models.Turist;
import com.example.demo.Register.Repository.TuristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TuristService implements ITuristService{

@Autowired
private TuristRepository turistRepository;

public TuristService(TuristRepository turistRepository){
    this.turistRepository=turistRepository;
}



    @Override
    public void createTurist(Turist turist) {

    }

    @Override
    public void deleteTurist(int Id) {

    }

    @Override
    public void editTurist(int id) {

    }
}
package com.example.demo.Register.Service;

import com.example.demo.Register.Models.Business;
import com.example.demo.Register.Repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService implements IBusinessService{

@Autowired
private BusinessRepository businessRepository;

public BusinessService(BusinessRepository businessRepository){
    this.businessRepository=businessRepository;
}



    @Override
    public void createBusiness(Business business) {

    }

    @Override
    public void deleteBusiness(int Id) {

    }

    @Override
    public void editBusiness(int id) {

    }
}

package com.example.demo.Register.Authentication;

import com.example.demo.Register.Controller.BusinessController;
import com.example.demo.Register.Models.Business;
import com.example.demo.Register.Repository.BusinessRepository;

import java.util.List;

public class Authentication implements AuthenticationInterface {

    private BusinessController businessController;
    private BusinessRepository businessRepository;



    public Authentication(BusinessRepository businessRepository){
        this.businessRepository=businessRepository;
    }

    @Override
    public boolean checkTouristPassword(String password) {

        return false;
    }

    @Override
    public boolean checkTouristUsername(String username) {
        return false;
    }

    @Override
    public boolean checkBusinessPassword(String username, String password) {
        boolean usernameExist = checkBusinessUsername(username);
        Business business=null;
        if(usernameExist == true){
            business = this.businessRepository.findBusinessByUsername(username);
        }
        if(business.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean checkBusinessUsername(String username) {

        List<Business> businesses = this.businessRepository.findAll();
        int result=0;

        for (int i=0; i<businesses.size();i++){
            Business business = businesses.get(i);
            if(business.getEmail().equals(username) || business.getUsername().equals(username)){
                result=1;
                break;
            }else{
                result=-1;
            }
        }
        if(result==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean checkAdminPassword(String password) {
        return false;
    }

    @Override
    public boolean checkAdminUsername(String username) {
        return false;
    }
}

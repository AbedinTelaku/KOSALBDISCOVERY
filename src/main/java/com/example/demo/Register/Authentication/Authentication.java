package com.example.demo.Register.Authentication;

import com.example.demo.Register.Models.Business;
import com.example.demo.Register.Repository.BusinessRepository;
import com.example.demo.Register.Controller.TouristController;
import com.example.demo.Register.Models.Tourist;
import com.example.demo.Register.Repository.TouristRepository;

public class Authentication implements AuthenticationInterface {


    private BusinessRepository businessRepository;
    private TouristController touristController;
    private TouristRepository touristRepository;



    public Authentication(BusinessRepository businessRepository){
        this.businessRepository=businessRepository;
    }

    @Override
    public boolean checkTouristPassword(String username, String password) {

         boolean usernameExist = checkTouristUsername(username);
        Tourist tourist=null;
        if(usernameExist == true){
            tourist = this.touristRepository.findTouristByUsername(username);
        }
        if(tourist.getPassword().equals(password)){
            return true;
        }else{
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

        Business business = this.businessRepository.findBusinessByUsername(username);

        if(business != null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean checkIfBusinessExist(String username, String password){
        boolean usernameExist = checkBusinessUsername(username);
        boolean passwordExist = checkBusinessPassword(username,password);

        if(usernameExist == true && passwordExist == true){
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

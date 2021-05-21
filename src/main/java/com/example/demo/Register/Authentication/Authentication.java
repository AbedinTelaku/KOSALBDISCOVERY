package com.example.demo.Register.Authentication;

import com.example.demo.Register.Controller.BusinessController;
import com.example.demo.Register.Models.Business;
import com.example.demo.Register.Repository.BusinessRepository;
import com.example.demo.Register.Controller.TouristController;
import com.example.demo.Register.Models.Tourist;
import com.example.demo.Register.Repository.TouristRepository;

import java.util.List;

public class Authentication implements AuthenticationInterface {

    private BusinessController businessController;
    private BusinessRepository businessRepository;
    private TouristController touristController;
    private TouristRepository touristRepository;



    public Authentication(BusinessRepository businessRepository){
        this.businessRepository=businessRepository;
    }

    @Override
    public boolean checkTouristPassword(String password) {

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
        List<Tourist> tourists = this.touristRepository.findAll();
        int result=0;

        for (int i=0; i<tourists.size();i++){
            Tourist tourist = tourists.get(i);
            if(tourist.getEmail().equals(username) || tourist.getUsername().equals(username)){
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

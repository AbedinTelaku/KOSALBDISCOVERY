package com.example.demo.Register.Authentication;


import com.example.demo.Register.Models.Business;
import com.example.demo.Register.Repository.AdminRepository;
import com.example.demo.Register.Repository.BusinessRepository;
import com.example.demo.Register.Models.Tourist;
import com.example.demo.Register.Repository.TouristRepository;

import java.util.Optional;

public class Authentication implements AuthenticationInterface {


    private BusinessRepository businessRepository;
    private TouristRepository touristRepository;
    private AdminRepository adminRepository;


    public Authentication(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    public Authentication(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public Authentication(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public boolean checkTouristPassword(String username, String password) {

        boolean usernameExist = checkTouristUsername(username);
        Optional<Tourist> touristOptional = null;
        Tourist tourist=null;
        if (usernameExist == true) {
            touristOptional = this.touristRepository.findTouristByUsername(username);
            tourist=touristOptional.get();
        }
        if (tourist.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkTouristUsername(String username) {
        Optional<Tourist> touristOptional = this.touristRepository.findTouristByUsername(username);
        Tourist tourist=touristOptional.get();

        if (tourist != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkIfTouristExist(String username, String password) {
        boolean usernameExist = checkTouristUsername(username);
        boolean passwordExist = checkTouristPassword(username, password);

        if (usernameExist == true && passwordExist == true) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean checkBusinessPassword(String username, String password) {
        boolean usernameExist = checkBusinessUsername(username);
        Optional<Business> businessOptional=null;
        Business business = null;
        if (usernameExist == true) {
            businessOptional = this.businessRepository.findBusinessByUsername(username);
            business=businessOptional.get();
        }
        if (business.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkBusinessUsername(String username) {

        Optional<Business> businessOptional = this.businessRepository.findBusinessByUsername(username);
        Business business=businessOptional.get();

        if (business != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkIfBusinessExist(String username, String password) {
        boolean usernameExist = checkBusinessUsername(username);
        boolean passwordExist = checkBusinessPassword(username, password);

        if (usernameExist == true && passwordExist == true) {
            return true;
        } else {
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

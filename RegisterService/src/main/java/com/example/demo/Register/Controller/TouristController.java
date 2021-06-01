package com.example.demo.Register.Controller;

import com.example.demo.Register.Authentication.AuthenticationInterface;
import com.example.demo.Register.Helper.LoginHelper;
import com.example.demo.Register.Helper.TouristHelper;
import com.example.demo.Register.Models.Tourist;
import com.example.demo.Register.Service.ITouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/tourist")
public class TouristController{
    private AuthenticationInterface authenticationInterface;

    @Autowired
    private ITouristService interfaceTouristService;



    @PostMapping("create/tourist")
    public void createTourist(@RequestBody TouristHelper touristHelper){
        this.interfaceTouristService.createTourist(touristHelper.getName(),touristHelper.getSurname(), touristHelper.getAge(), touristHelper.getGender(), touristHelper.getEmail(), touristHelper.getPassword(), touristHelper.getUsername(), touristHelper.getRole());
    }

    @PostMapping("get/tourist")
    public Tourist getTourist(@RequestBody LoginHelper loginHelper){
        String username = loginHelper.getUsername();
        String password = loginHelper.getPassword();

        return this.interfaceTouristService.getTouristByUsernameAndPassword(username,password);
    }

    @PostMapping("check/tourist")
    public boolean TouristExist(@RequestBody LoginHelper loginHelper){
        String username = loginHelper.getUsername();
        String password = loginHelper.getPassword();

        boolean checkUsername = this.authenticationInterface.checkIfTouristExist(username,password);

        return checkUsername;
    }

    @GetMapping("get/all/tourists")
    public List<Tourist> getAllTourists() {
        return this.interfaceTouristService.getAllTourists();
    }

    @GetMapping("get/tourists/number")
    public long getTouristsNumber() {
        return this.interfaceTouristService.getTouristsNumber();
    }
}
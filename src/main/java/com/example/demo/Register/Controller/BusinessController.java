package com.example.demo.Register.Controller;

import com.example.demo.Register.Authentication.AuthenticationInterface;
import com.example.demo.Register.Helper.BusinessHelper;
import com.example.demo.Register.Helper.LoginHelper;
import com.example.demo.Register.Helper.StatusHelper;
import com.example.demo.Register.Models.Business;
import com.example.demo.Register.Service.IBusinessService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/business")
public class BusinessController {
    private IBusinessService interfaceBusinessService ;
    private AuthenticationInterface authenticationInterface;

    public BusinessController(IBusinessService interfaceBusinessService){
        this.interfaceBusinessService=interfaceBusinessService;
    }


    @PostMapping("/create/business")
    public void registerBusiness(@RequestBody BusinessHelper businessHelper){
        this.interfaceBusinessService.createBusiness(businessHelper.getName(),businessHelper.getEmail(), businessHelper.getPassword(), businessHelper.getUsername(), businessHelper.getTel_Number(), businessHelper.getOwner_ID(), businessHelper.getFiscal_Number(), businessHelper.getBusiness_Number(), businessHelper.getBusiness_Activity(),businessHelper.getStatus() ,businessHelper.getRole());

    }

    @GetMapping("/get/business")
    public Business getBusiness(@RequestBody LoginHelper loginHelper){
        String username = loginHelper.getUsername();
        String password = loginHelper.getPassword();

       return this.interfaceBusinessService.getBusinessByUsernameAndPassword(username,password);
    }

    @PostMapping("/check/business")
    public boolean businessExist(@RequestBody LoginHelper loginHelper){
        String username = loginHelper.getUsername();
        String password = loginHelper.getPassword();

      boolean checkUsername = this.authenticationInterface.checkIfBusinessExist(username,password);

      return checkUsername;
    }

    @GetMapping("/get/all/businesses")
    public List<Business> getAllBusinesess(){
        return this.interfaceBusinessService.getAllBusinesses();
    }

    @PostMapping("/delete/business/by/{id}")
    public void deleteBusiness(@PathVariable("id") int id){

        this.interfaceBusinessService.deleteBusiness(id);
    }

    @PostMapping("/edit/business/status")
    public void blockBusiness(@RequestBody StatusHelper statusHelper){
        this.interfaceBusinessService.editBusinessStatus(statusHelper.getUserId(),statusHelper.getStatus());

    }
}

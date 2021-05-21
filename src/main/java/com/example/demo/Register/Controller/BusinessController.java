package com.example.demo.Register.Controller;

import com.example.demo.Register.Authentication.AuthenticationInterface;
import com.example.demo.Register.Helper.BusinessHelper;
import com.example.demo.Register.Helper.LoginHelper;
import com.example.demo.Register.Models.Business;
import com.example.demo.Register.Service.IBusinessService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/business")
public class BusinessController {
    private IBusinessService interfaceBusinessService ;
    private AuthenticationInterface authenticationInterface;

    public BusinessController(IBusinessService interfaceBusinessService){
        this.interfaceBusinessService=interfaceBusinessService;
    }


    @PostMapping("create/business")
    public void registerBusiness(@RequestBody BusinessHelper businessHelper){
        this.interfaceBusinessService.createBusiness(businessHelper.getName(),businessHelper.getEmail(), businessHelper.getPassword(), businessHelper.getUsername(), businessHelper.getTel_Number(), businessHelper.getOwner_ID(), businessHelper.getFiscal_Number(), businessHelper.getBusiness_Number(), businessHelper.getBusiness_Activity(), businessHelper.getRole());

    }

    @PostMapping("get/business")
    public Business getBusiness(@RequestBody LoginHelper loginHelper){
        String username = loginHelper.getUsername();
        String password = loginHelper.getPassword();

       return this.interfaceBusinessService.getBusinessByUsernameAndPassword(username,password);
    }

    @PostMapping("check/business")
    public boolean businessExist(@RequestBody LoginHelper loginHelper){
        String username = loginHelper.getUsername();
        String password = loginHelper.getPassword();

      boolean checkUsername = this.authenticationInterface.checkIfBusinessExist(username,password);

      return checkUsername;
    }
}

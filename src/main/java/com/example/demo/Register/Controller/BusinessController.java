package com.example.demo.Register.Controller;

import com.example.demo.Register.Helper.BusinessHelper;
import com.example.demo.Register.Service.IBusinessService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/business")
public class BusinessController {
    private IBusinessService interfaceBusinessService ;

    public BusinessController(IBusinessService interfaceBusinessService){
        this.interfaceBusinessService=interfaceBusinessService;
    }


    @GetMapping("create/Business")
    public void registerBusiness(@RequestBody BusinessHelper businessHelper){
        this.interfaceBusinessService.createBusiness(businessHelper.getName(),businessHelper.getEmail(), businessHelper.getPassword(), businessHelper.getUsername(), businessHelper.getTel_Number(), businessHelper.getOwner_ID(), businessHelper.getFiscal_Number(), businessHelper.getBusiness_Number(), businessHelper.getBusiness_Activity(), businessHelper.getRole());

    }
}

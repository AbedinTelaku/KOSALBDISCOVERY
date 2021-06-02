package com.example.demo.Register.Controller;

import com.example.demo.Register.Service.IBusinessService;
import com.example.demo.Register.Service.ITouristService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UsersController {

     private IBusinessService interfaceBusinessService ;
    private ITouristService interfaceTouristService ;

    public UsersController(IBusinessService interfaceBusinessService, ITouristService interfaceTouristService) {
        this.interfaceBusinessService = interfaceBusinessService;
        this.interfaceTouristService = interfaceTouristService;
    }


    @GetMapping("/get/users/number")
    public long getUsersNumber(){
        return this.interfaceBusinessService.getBusinessesNumber()+this.interfaceTouristService.getTouristsNumber();
    }
}

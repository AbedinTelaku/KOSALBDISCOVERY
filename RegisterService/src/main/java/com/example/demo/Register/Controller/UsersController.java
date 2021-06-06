package com.example.demo.Register.Controller;

import com.example.demo.Register.Models.Business;
import com.example.demo.Register.Models.Tourist;
import com.example.demo.Register.Service.IBusinessService;
import com.example.demo.Register.Service.ITouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UsersController {

    @Autowired
    private IBusinessService interfaceBusinessService;
    @Autowired
    private ITouristService interfaceTouristService;

    public UsersController(IBusinessService interfaceBusinessService, ITouristService interfaceTouristService) {
        this.interfaceBusinessService = interfaceBusinessService;
        this.interfaceTouristService = interfaceTouristService;
    }


    @GetMapping("/get/users/number")
    public long getUsersNumber() {
        return this.interfaceBusinessService.getBusinessesNumber() + this.interfaceTouristService.getTouristsNumber();
    }
    @GetMapping("/get/users/numbers")
    public List<Long> getTouristsAndBusinessesNumber() {
        long tNum = this.interfaceTouristService.getTouristsNumber();
        long bNum = this.interfaceBusinessService.getBusinessesNumber();

        List<Long> numbers = new ArrayList<Long>();
        numbers.add(tNum);
        numbers.add(bNum);

        return numbers;
    }
    @GetMapping("/get/user/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable("username") String username) {
        Business business = this.interfaceBusinessService.getBusinessByUsername(username);
        Tourist tourist = this.interfaceTouristService.getTouristByUsername(username);

      if (business == null) {
            if(tourist == null){
            return  ResponseEntity.notFound().build();
            }else{
           return ResponseEntity.ok(tourist);
             }
        } else {
            return ResponseEntity.ok(business);
       }

    }

}

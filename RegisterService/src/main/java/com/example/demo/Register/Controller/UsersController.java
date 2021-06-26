package com.example.demo.Register.Controller;

import com.example.demo.Register.Models.Admin;
import com.example.demo.Register.Models.Business;
import com.example.demo.Register.Models.Tourist;
import com.example.demo.Register.Service.IAdminService;
import com.example.demo.Register.Service.IBusinessService;
import com.example.demo.Register.Service.ITouristService;
import com.example.demo.Register.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/register/user")
public class UsersController {

    @Autowired
    private IBusinessService interfaceBusinessService;
    @Autowired
    private ITouristService interfaceTouristService;
    @Autowired


    private IAdminService iAdminService;
    @Autowired

    private IUserService iUserService;

    public UsersController(IBusinessService interfaceBusinessService, ITouristService interfaceTouristService, IUserService iUserService) {
        this.interfaceBusinessService = interfaceBusinessService;
        this.interfaceTouristService = interfaceTouristService;
        this.iUserService = iUserService;
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



      if (business == null) {
          Tourist tourist = this.interfaceTouristService.getTouristByUsername(username);
            if(tourist == null){
                Admin admin = this.iAdminService.getAdminByUsername(username);
                if(admin == null){

                    return  ResponseEntity.notFound().build();
                }else{
                    return ResponseEntity.ok(admin);
                }

            }else{
           return ResponseEntity.ok(tourist);
             }
        } else {
            return ResponseEntity.ok(business);
       }

    }

  //  @GetMapping("/check/user/{username}/{password}")
   // public boolean checkIfUserExist(@PathVariable("username") String username, @PathVariable("password") String password){
   //     GeneralResponse generalResponse = this.iUserService.checkIfUserExist(username,password);

     //   if(generalResponse.getError() == null){
      //      return true;
      //  }else{
     //       return false;
      //  }

  //  }

    @GetMapping("/check/user/{username}/{password}")
        public ResponseEntity<?> checkIfUserIsValid(@PathVariable("username") String username, @PathVariable("password") String password){
           return this.iUserService.checkIfUserIsValid(username,password);
        }

}

package com.example.demo.Register.Controller;

import com.example.demo.Register.Authentication.AuthenticationInterface;
import com.example.demo.Register.Helper.AdminHelper;
import com.example.demo.Register.Helper.LoginHelper;
import com.example.demo.Register.Models.Admin;
import com.example.demo.Register.Service.IAdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class AdminController {

    private IAdminService interfaceAdminService ;
    private AuthenticationInterface authenticationInterface;

    public AdminController(IAdminService interfaceAdminService){
        this.interfaceAdminService=interfaceAdminService;
    }


    @PostMapping("create/admin")
    public void registerAdmin(@RequestBody AdminHelper adminHelper){
        this.interfaceAdminService.createAdmin(adminHelper.getName(),adminHelper.getEmail(), adminHelper.getSurname(), adminHelper.getUsername(), adminHelper.getPassword(), adminHelper.getGender());
    }

    @PostMapping("get/admin")
    public Admin getAdmin(@RequestBody LoginHelper loginHelper){
        String username = loginHelper.getUsername();
        String password = loginHelper.getPassword();

        return this.interfaceAdminService.getAdminByUsernameAndPassword(username,password);
    }

    @PostMapping("check/admin")
    public boolean AdminExist(@RequestBody LoginHelper loginHelper){
        String username = loginHelper.getUsername();
        String password = loginHelper.getPassword();

        boolean checkUsername = this.authenticationInterface.checkAdminUsername(username);
        boolean checkPassword = this.authenticationInterface.checkAdminPassword(password);

        return checkUsername;

    }

    @GetMapping("get/all/admin")
    public List<Admin> getAllBusinesess(){
        return this.interfaceAdminService.getAllAdmin();
    }
}

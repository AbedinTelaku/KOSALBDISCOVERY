package com.example.demo.Register.Controller;

import com.example.demo.Register.Helper.RegisterHelper;
import com.example.demo.Register.Models.Admin;
import com.example.demo.Register.Service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterHelper register){
        Admin admin=this.adminService.register(register.getName(),register.getSurname(),register.getUsername(),register.getPassword());

        if(admin == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(admin);
    }
}

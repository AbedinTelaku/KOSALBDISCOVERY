package com.example.Register.Controller;

import com.example.demo.Register.Helper.LoginHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.Register.Service.ITuristService;
import com.example.demo.Register.Models.Turist;



@RestController
@RequestMapping("/api/turist")
public class TuristController{

    @Autowired
    private ITuristService turistService;


     @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginHelper login){
        Turist turist=this.turistService.login(login.getUsername(),login.getPassword());

        if(turist==null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(turist);
    }


}
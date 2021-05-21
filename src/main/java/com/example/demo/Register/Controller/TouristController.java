package com.example.Register.Controller;

import com.example.demo.Register.Helper.LoginHelper;
import com.example.demo.Register.Models.Tourist;
import com.example.demo.Register.Service.ITouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/tourist")
public class TouristController{

    @Autowired
    private ITouristService touristService;
    
    
    
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginHelper login){
        Tourist tourist=this.touristService.login(login.getUsername(),login.getPassword());

        if(tourist==null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(tourist);
    }


}
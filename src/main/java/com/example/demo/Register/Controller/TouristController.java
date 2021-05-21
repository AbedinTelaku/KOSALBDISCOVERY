package com.example.Register.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.Register.Service.ITouristService;
import com.example.demo.Register.Models.Tourist;



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
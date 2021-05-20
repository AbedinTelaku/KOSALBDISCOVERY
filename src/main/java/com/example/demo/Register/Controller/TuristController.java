package com.example.Register.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.Register.Service.ITuristService;



@RestController
@RequestMapping("/api/turist")
public class TuristController{

    @Autowired
    private ITuristService turistService;


}
package com.example.demo.Application.InputAdapter;

import com.example.demo.Application.InputPort.EmailInputPort;
import com.example.demo.Core.Helper.TouristHelper;
import com.example.demo.Core.OutputPort.TouristOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {
    @Autowired
    private EmailInputPort emailInputPort;



    public EmailController(EmailInputPort emailInputPort){
        this.emailInputPort=emailInputPort;
    }

    @PostMapping("/message")
    public String sendEmailMessage(@RequestBody TouristHelper touristHelper){
        this.emailInputPort.sendMessage(touristHelper.getEmail(), "Confirmation", "By this email we are confirming your participation for event");
          return "Message is sent";
    }


}

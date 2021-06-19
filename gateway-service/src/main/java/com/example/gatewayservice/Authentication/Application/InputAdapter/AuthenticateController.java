package com.example.gatewayservice.Authentication.Application.InputAdapter;


import com.example.gatewayservice.Authentication.Application.InputPort.AuthenticateInputPort;
import com.example.gatewayservice.Authentication.Core.Helper.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authenticate")
public class AuthenticateController {

    @Autowired
    private AuthenticateInputPort authenticateInputPort;

    public AuthenticateController(AuthenticateInputPort authenticateInputPort) {
        this.authenticateInputPort = authenticateInputPort;
    }

    @PostMapping("/checkUser")
    public boolean checkIfUserExist(@RequestBody UserHelper userhelper){
        return this.authenticateInputPort.checkIfUserExist(userhelper.getUsername(),userhelper.getPassword());
    }
}

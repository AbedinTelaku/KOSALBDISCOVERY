package com.example.gatewayservice.Authentication.Application.InputAdapter;


import com.example.gatewayservice.Authentication.Application.InputPort.AuthenticateInputPort;
import com.example.gatewayservice.Authentication.Core.Helper.RequestHelper;
import com.example.gatewayservice.Authentication.Core.Helper.ResponseHelper;
import com.example.gatewayservice.Authentication.Core.Helper.SignInHelper;
import com.example.gatewayservice.Authentication.Core.Helper.UserHelper;
import com.example.gatewayservice.Authentication.Core.Service.UserService;
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

    @Autowired
    private UserService userService;


    public AuthenticateController(AuthenticateInputPort authenticateInputPort) {
        this.authenticateInputPort = authenticateInputPort;
    }

    //user gets token from responseHelper
    @PostMapping("/signIn")
    public ResponseHelper signIn(@RequestBody RequestHelper requestHelper){
        return this.authenticateInputPort.signIn(requestHelper);
    }
    @PostMapping("/checkUser")
    public boolean checkIfUserExist(@RequestBody UserHelper userhelper){
        return this.authenticateInputPort.checkIfUserExist(userhelper.getUsername(),userhelper.getPassword());
    }

    @PostMapping("/auth/user")
    public ResponseHelper authenticateUser(@RequestBody RequestHelper requestHelper){
        ResponseHelper responseHelper = new ResponseHelper(requestHelper.getUsername(),this.authenticateInputPort.generateToken(requestHelper));
        return responseHelper;
    }


}

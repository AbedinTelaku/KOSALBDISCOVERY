package com.example.gatewayservice.Authentication.Application.InputAdapter;


import com.example.gatewayservice.Authentication.Application.InputPort.AuthenticateInputPort;
import com.example.gatewayservice.Authentication.Core.Helper.RequestHelper;
import com.example.gatewayservice.Authentication.Core.Helper.ResponseHelper;
import com.example.gatewayservice.Authentication.Core.Helper.SignInHelper;
import com.example.gatewayservice.Authentication.Core.Helper.UserHelper;
import com.example.gatewayservice.Authentication.Core.OutputPort.AuthenticateOutputPort;
import com.example.gatewayservice.Authentication.Core.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authenticate")
public class AuthenticateController {

    @Autowired
    private AuthenticateInputPort authenticateInputPort;

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticateOutputPort authenticateOutputPort;




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

    @GetMapping("/validate/{token}")
    public ResponseHelper validateToken(@PathVariable("token") String token){
        return this.authenticateInputPort.getResponseHelperFromValidToken(token);
    }


    @GetMapping("/get/user/{username}")
    public UserHelper getUser(@PathVariable("username") String username){
        return this.authenticateOutputPort.getUserByUsername(username);
    }

}

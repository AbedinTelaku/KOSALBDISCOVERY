package com.example.gatewayservice.Authentication.Core.Service;

import com.example.gatewayservice.Authentication.Application.InputPort.AuthenticateInputPort;
import com.example.gatewayservice.Authentication.Core.Domain.AuthenticationDomain;
import com.example.gatewayservice.Authentication.Core.Exception.AppException;
import com.example.gatewayservice.Authentication.Core.Helper.RequestHelper;
import com.example.gatewayservice.Authentication.Core.Helper.SignInHelper;
import com.example.gatewayservice.Authentication.Core.Helper.UserHelper;
import com.example.gatewayservice.Authentication.Core.OutputPort.AuthenticateOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateService implements AuthenticateInputPort {
    @Autowired
    private AuthenticateOutputPort authenticateOutputPort;

    @Autowired
    private AuthenticationDomain authenticationDomain;

    public AuthenticateService(AuthenticateOutputPort authenticateOutputPort) {
        this.authenticateOutputPort = authenticateOutputPort;
    }

    @Override
    public boolean checkIfUserExist(String username, String password) {
        return this.authenticateOutputPort.userExist(username,password);

        //if user exist call authenticationDomain to create user JWT

    }

    @Override
    public String generateToken(RequestHelper requestHelper) {
        this.authenticationDomain=new AuthenticationDomain();
        UserHelper userHelper = new UserHelper(requestHelper.getUsername(),requestHelper.getPassword());
        return this.authenticationDomain.generateToken(userHelper);
    }

    @Override
    public SignInHelper signIn(RequestHelper requestHelper){
        if(checkIfUserExist(requestHelper.getUsername(),requestHelper.getPassword())){
            return new SignInHelper(requestHelper.getUsername(),generateToken(requestHelper));

        }

        throw new AppException("Invalid Password or Username", HttpStatus.BAD_REQUEST);

    }
}

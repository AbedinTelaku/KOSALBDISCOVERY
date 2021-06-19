package com.example.gatewayservice.Authentication.Core.Service;

import com.example.gatewayservice.Authentication.Application.InputPort.AuthenticateInputPort;
import com.example.gatewayservice.Authentication.Core.OutputPort.AuthenticateOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateService implements AuthenticateInputPort {
    @Autowired
    private AuthenticateOutputPort authenticateOutputPort;

    public AuthenticateService(AuthenticateOutputPort authenticateOutputPort) {
        this.authenticateOutputPort = authenticateOutputPort;
    }

    @Override
    public boolean checkIfUserExist(String username, String password) {
        return this.authenticateOutputPort.userExist(username,password);

        //if user exist call authenticationDomain to create user JWT
    }
}

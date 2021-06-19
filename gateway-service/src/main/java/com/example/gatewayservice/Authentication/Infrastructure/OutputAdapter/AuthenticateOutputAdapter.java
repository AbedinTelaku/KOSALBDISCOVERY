package com.example.gatewayservice.Authentication.Infrastructure.OutputAdapter;


import com.example.gatewayservice.Authentication.Core.OutputPort.AuthenticateOutputPort;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateOutputAdapter implements AuthenticateOutputPort {
    @Override
    public boolean userExist(String username, String password) {
        return false;
    }
}

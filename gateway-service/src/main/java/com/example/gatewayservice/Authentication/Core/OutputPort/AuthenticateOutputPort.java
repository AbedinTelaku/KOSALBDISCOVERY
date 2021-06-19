package com.example.gatewayservice.Authentication.Core.OutputPort;

public interface AuthenticateOutputPort {
    public boolean userExist(String username, String password);
}

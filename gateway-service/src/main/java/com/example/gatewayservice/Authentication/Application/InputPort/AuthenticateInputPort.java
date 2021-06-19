package com.example.gatewayservice.Authentication.Application.InputPort;

public interface AuthenticateInputPort {
    boolean checkIfUserExist(String username,String password);
}

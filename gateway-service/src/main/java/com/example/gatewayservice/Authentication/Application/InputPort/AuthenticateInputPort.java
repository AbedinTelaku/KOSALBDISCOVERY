package com.example.gatewayservice.Authentication.Application.InputPort;

import com.example.gatewayservice.Authentication.Core.Helper.RequestHelper;
import com.example.gatewayservice.Authentication.Core.Helper.SignInHelper;
import com.example.gatewayservice.Authentication.Core.Helper.UserHelper;


public interface AuthenticateInputPort {
    boolean checkIfUserExist(String username,String password);
    String generateToken(RequestHelper requestHelper);
    SignInHelper signIn(RequestHelper requestHelper);

}
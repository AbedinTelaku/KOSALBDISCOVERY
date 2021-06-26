package com.example.gatewayservice.Authentication.Application.InputPort;

import com.example.gatewayservice.Authentication.Core.Helper.RequestHelper;
import com.example.gatewayservice.Authentication.Core.Helper.ResponseHelper;
import com.example.gatewayservice.Authentication.Core.Helper.SignInHelper;
import com.example.gatewayservice.Authentication.Core.Helper.UserHelper;


public interface AuthenticateInputPort {
    boolean checkIfUserExist(String username,String password);
    String generateToken(RequestHelper requestHelper);
    ResponseHelper signIn(RequestHelper requestHelper);
    boolean validateToken(String token);
    ResponseHelper getResponseHelperFromValidToken(String token);

}

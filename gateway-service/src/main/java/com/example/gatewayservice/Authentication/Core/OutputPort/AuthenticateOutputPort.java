package com.example.gatewayservice.Authentication.Core.OutputPort;

import com.example.gatewayservice.Authentication.Core.Helper.UserHelper;

public interface AuthenticateOutputPort {
    public boolean userExist(String username, String password);
    public UserHelper getUserByUsername(String username);
}

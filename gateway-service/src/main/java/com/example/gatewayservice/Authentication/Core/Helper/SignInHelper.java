package com.example.gatewayservice.Authentication.Core.Helper;

import java.io.Serializable;

public class SignInHelper implements Serializable {
    private String username;
    private String token;

    public SignInHelper(String username, String token) {
        this.username = username;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

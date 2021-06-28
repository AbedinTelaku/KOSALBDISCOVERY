package com.example.gatewayservice.Authentication.Core.Helper;

import java.io.Serializable;

public class RequestHelper implements Serializable {
    private String username;
    private String password;

    public RequestHelper(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

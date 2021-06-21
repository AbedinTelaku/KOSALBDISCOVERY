package com.example.gatewayservice.Authentication.Core.Helper;

import java.io.Serializable;

public class ResponseHelper implements Serializable {
    private String token;

    public ResponseHelper(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

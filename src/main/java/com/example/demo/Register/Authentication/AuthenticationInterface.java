package com.example.demo.Register.Authentication;

public interface AuthenticationInterface {

    boolean checkTouristPassword(String password);
    boolean checkTouristUsername(String username);

    boolean checkBusinessPassword(String Username, String password);
    boolean checkBusinessUsername(String username);

    boolean checkAdminPassword(String password);
    boolean checkAdminUsername(String username);
}

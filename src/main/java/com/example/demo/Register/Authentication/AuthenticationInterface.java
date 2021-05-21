package com.example.demo.Register.Authentication;

public interface AuthenticationInterface {

    boolean checkTouristPassword(String username,String password);
    boolean checkTouristUsername(String username);

    boolean checkIfBusinessExist(String username, String password);
    boolean checkBusinessPassword(String Username, String password);
    boolean checkBusinessUsername(String username);

    boolean checkAdminPassword(String password);
    boolean checkAdminUsername(String username);
}

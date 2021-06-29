package com.example.demo.Register.Service;


import com.example.demo.Register.Helper.RequestHelper;
import com.example.demo.Register.Helper.ResponseHelper;

public interface IAuthenticateService {
    boolean checkIfUserExist(String username,String password);
    String generateToken(RequestHelper requestHelper);
    ResponseHelper signIn(RequestHelper requestHelper);
    //boolean validateToken(String token);
    //ResponseHelper getResponseHelperFromValidToken(String token);

}

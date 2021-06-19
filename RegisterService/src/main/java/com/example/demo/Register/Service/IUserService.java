package com.example.demo.Register.Service;

import com.example.demo.Register.Helper.GeneralResponse;
import org.springframework.http.ResponseEntity;

public interface IUserService {

    GeneralResponse checkIfUserExist(String username, String password);

    ResponseEntity<?> checkIfUserIsValid(String username, String password);
}

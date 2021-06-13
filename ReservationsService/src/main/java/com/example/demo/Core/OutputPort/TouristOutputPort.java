package com.example.demo.Core.OutputPort;


import com.example.demo.Core.Helper.TouristHelper;

public interface TouristOutputPort {
    TouristHelper getTouristByUsername(String username);
    // !!!!! ju keni me bo get room edhe business by id !!!!
}

package com.example.demo.Register.Service;

import com.example.demo.Register.Models.Business;

public interface IBusinessService {
    void createBusiness(Business business);
    void deleteBusiness(int Id);
    void editBusiness(int id);
}

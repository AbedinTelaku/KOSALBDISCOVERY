package com.example.demo.Register.Service;

import com.example.demo.Register.Models.Business;

public interface IBusinessService {
    Business getBusiness(int id);
    void createBusiness(String name, String email, String password, String username, String tel_Number, String owner_ID, String fiscal_Number, String business_Number, String business_Activity, String role);
    void deleteBusiness(int id);
    void editBusiness(int id,String businessId,String businessActivity,String businessNumber,String email,String fiscalNumber,String name,String ownerId,String password,String telNumber,String username,String role);
}

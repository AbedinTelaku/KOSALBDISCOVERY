package com.example.demo.Service;

import com.example.demo.Models.Payment;

public interface IPaymentService {
    void createPayment(double amount, String hotel,String roomType,int roomNumber);
    void deletePayment(int id);
    Payment getPayment(int id);
}

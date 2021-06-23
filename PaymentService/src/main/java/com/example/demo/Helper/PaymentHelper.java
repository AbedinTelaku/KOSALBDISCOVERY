package com.example.demo.Helper;

import java.io.Serializable;

public class PaymentHelper implements Serializable {
    private double amount;
    private String hotel;
    private String roomType;
    private int roomNumber;


    public PaymentHelper(double amount, String hotel, String roomType, int roomNumber) {
        this.amount = amount;
        this.hotel = hotel;
        this.roomType = roomType;
        this.roomNumber = roomNumber;
    }

    public double getAmount() {
        return amount;
    }

    public String getHotel() {
        return hotel;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
}

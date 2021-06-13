package com.example.demo.Core.Entities;

import javax.persistence.Embeddable;

@Embeddable
public class Room {
    private int number;
    private double price;
    private String type;

    public Room(int number, double price, String type) {
        this.number = number;
        this.price = price;
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

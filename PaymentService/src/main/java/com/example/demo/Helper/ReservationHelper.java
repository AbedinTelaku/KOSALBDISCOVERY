package com.example.demo.Helper;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class ReservationHelper implements Serializable {
    private Time time;
    private Date date;
    private Date checkInDate;
    private Date checkOutDate;
    private int roomId;
    private int businessId;
    private String touristUsername;

    public ReservationHelper(Time time, Date date, Date checkInDate, Date checkOutDate, int roomId, int businessId, String touristUsername) {
        this.time = time;
        this.date = date;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomId = roomId;
        this.businessId = businessId;
        this.touristUsername = touristUsername;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public String getTouristUsername() {
        return touristUsername;
    }

    public void setTouristUsername(String touristUsername) {
        this.touristUsername = touristUsername;
    }
}

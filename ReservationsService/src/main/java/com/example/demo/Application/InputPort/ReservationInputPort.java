package com.example.demo.Application.InputPort;

import com.example.demo.Core.Entities.Business;
import com.example.demo.Core.Entities.Reservation;
import com.example.demo.Core.Entities.Room;
import com.example.demo.Core.Entities.Tourist;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface ReservationInputPort {
    void createReservation(Time reservationTime, Date reservationDate , Date checkInDate, Date checkOutDate, int roomId, int businessId, String touristUsername);
    Reservation getReservationById(int id);
    List<Reservation> getAllReservations();
    void deleteReservation(int id);
}

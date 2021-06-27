package com.example.demo.Core.Domain;

import com.example.demo.Core.Entities.Business;
import com.example.demo.Core.Entities.Reservation;
import com.example.demo.Core.Entities.Room;
import com.example.demo.Core.Entities.Tourist;
import com.example.demo.Core.OutputPort.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class ReservationDomain {

    @Autowired
    private ReservationRepository reservationRepository;

    public ReservationDomain(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void createReservation(Time reservationTime, Date reservationDate , Date checkInDate, Date checkOutDate , Room room, Business business, Tourist tourist){
        int daysNumber = getNumberOfDays(checkInDate,checkOutDate);
        double totalPrice=daysNumber*setTotalPrice(room.getRoomPrice(), room.getRoomDiscount());


        Reservation reservation = new Reservation(reservationTime,reservationDate,checkInDate,checkOutDate,totalPrice,room.getRoomDiscount(),room,business,tourist);
        this.reservationRepository.save(reservation);


    }

    public double setTotalPrice(double roomPrice, double roomDiscount){
       roomPrice=roomPrice-(roomPrice*(roomDiscount/100));
       return roomPrice;
    }

    public int getNumberOfDays(Date checkInDate, Date checkOutDate){
       int numOfDays = (int) Math.round((checkInDate.getTime()-checkOutDate.getTime())/ (double)86400000);
       return Math.abs(numOfDays);
    }
}

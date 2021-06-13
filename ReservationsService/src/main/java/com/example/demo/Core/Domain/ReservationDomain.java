package com.example.demo.Core.Domain;

import com.example.demo.Core.OutputPort.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ReservationDomain {

    @Autowired
    private ReservationRepository reservationRepository;

    public ReservationDomain(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void createReservation(){

    }
}

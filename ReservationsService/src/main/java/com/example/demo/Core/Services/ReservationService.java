package com.example.demo.Core.Services;

import com.example.demo.Application.InputPort.ReservationInputPort;
import com.example.demo.Core.Domain.ReservationDomain;
import com.example.demo.Core.Entities.Business;
import com.example.demo.Core.Entities.Reservation;
import com.example.demo.Core.Entities.Room;
import com.example.demo.Core.Entities.Tourist;
import com.example.demo.Core.Helper.TouristHelper;
import com.example.demo.Core.OutputPort.ReservationRepository;
import com.example.demo.Core.OutputPort.TouristOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService implements ReservationInputPort {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private TouristOutputPort touristOutputPort;

    private ReservationDomain reservationDomain;


    public ReservationService(ReservationRepository reservationRepository, TouristOutputPort touristOutputPort) {
        this.reservationRepository = reservationRepository;
        this.touristOutputPort = touristOutputPort;
    }

    @Override
    public void createReservation(Time reservationTime, Date reservationDate, Date checkInDate, Date checkOutDate, double totalPrice, double discount,  int roomId, int businessId, String touristUsername) {
       reservationDomain=new ReservationDomain(this.reservationRepository);
       TouristHelper touristHelper = this.touristOutputPort.getTouristByUsername(touristUsername);
       Tourist tourist = new Tourist(touristHelper.getName(),touristHelper.getEmail());


       reservationDomain.createReservation();
    }

    @Override
    public Reservation getReservationById(int id) {
        Optional<Reservation> optionalReservation = this.reservationRepository.findById(id);
        return optionalReservation.get();
    }

    @Override
    public List<Reservation> getAllReservations() {
        return this.reservationRepository.findAll();
    }

    @Override
    public void deleteReservation(int id) {
     this.reservationRepository.deleteById(id);
    }
}

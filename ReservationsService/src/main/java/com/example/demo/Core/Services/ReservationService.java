package com.example.demo.Core.Services;

import com.example.demo.Application.InputPort.ReservationInputPort;
import com.example.demo.Core.Domain.ReservationDomain;
import com.example.demo.Core.Entities.Business;
import com.example.demo.Core.Entities.Reservation;
import com.example.demo.Core.Entities.Room;
import com.example.demo.Core.Entities.Tourist;
import com.example.demo.Core.Helper.TouristHelper;
import com.example.demo.Core.Helper.BusinessHelper;
import com.example.demo.Core.Helper.RoomHelper;
import com.example.demo.Core.OutputPort.ReservationRepository;
import com.example.demo.Core.OutputPort.TouristOutputPort;
import com.example.demo.Core.OutputPort.RoomOutputPort;
import com.example.demo.Core.OutputPort.BusinessOutputPort;
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

    @Autowired
    private RoomOutputPort roomOutputPort;

    @Autowired
    private BusinessOutputPort businessOutputPort;


    public ReservationService(ReservationRepository reservationRepository, TouristOutputPort touristOutputPort, RoomOutputPort roomOutputPort, BusinessOutputPort businessOutputPort) {
        this.reservationRepository = reservationRepository;
        this.touristOutputPort = touristOutputPort;
        this.roomOutputPort = roomOutputPort;
        this.businessOutputPort = businessOutputPort;

    }

    @Override
    public void createReservation(Time reservationTime, Date reservationDate, Date checkInDate, Date checkOutDate,  int roomId, int businessId, String touristUsername) {
       reservationDomain=new ReservationDomain(this.reservationRepository);

       TouristHelper touristHelper = this.touristOutputPort.getTouristByUsername(touristUsername);
        BusinessHelper businessHelper = this.businessOutputPort.getBusinessByID(businessId);
        RoomHelper roomHelper = this.roomOutputPort.getRoomByID(roomId);

       Tourist tourist = new Tourist(touristHelper.getUsername(),touristHelper.getEmail(),touristHelper.getName());
       Room room = new Room(roomHelper.getRoom_number(),roomHelper.getRoom_type(),roomHelper.getPrice(),roomHelper.getDiscount());
       Business bussines = new Business(businessHelper.getName(), businessHelper.getEmail(), businessHelper.getTel_Number(),businessHelper.getUsername());


       reservationDomain.createReservation(reservationTime,reservationDate,checkInDate,checkOutDate,room,bussines,tourist);
    }

    @Override
    public Reservation getReservationById(int id) {
        Optional<Reservation> optionalReservation = this.reservationRepository.findById(id);
        return optionalReservation.get();
    }

    @Override
    public List<Reservation> getReservationsByUsername(String username) {
        return this.reservationRepository.findReservationsByBusinessUsername(username);
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

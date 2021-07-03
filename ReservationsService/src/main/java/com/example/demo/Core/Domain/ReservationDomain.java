package com.example.demo.Core.Domain;

import com.example.demo.Core.Entities.Business;
import com.example.demo.Core.Entities.Reservation;
import com.example.demo.Core.Entities.Room;
import com.example.demo.Core.Entities.Tourist;
import com.example.demo.Core.Helper.RoomHelper;
import com.example.demo.Core.Helper.RoomsHelper;
import com.example.demo.Core.OutputPort.ReservationRepository;
import com.example.demo.Core.OutputPort.RoomOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import java.util.TimerTask;


@Component
public class ReservationDomain {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RoomOutputPort roomOutputPort;

    public ReservationDomain(ReservationRepository reservationRepository,RoomOutputPort roomOutputPort) {
        this.reservationRepository = reservationRepository;
        this.roomOutputPort = roomOutputPort;

    }

    public void createReservation(Time reservationTime, Date reservationDate , Date checkInDate, Date checkOutDate , Room room, Business business, Tourist tourist){
        int daysNumber = getNumberOfDays(checkInDate,checkOutDate);
        double totalPrice=daysNumber*setTotalPrice(room.getRoomPrice(), room.getRoomDiscount());


        Reservation reservation = new Reservation(reservationTime,reservationDate,checkInDate,checkOutDate,totalPrice,room.getRoomDiscount(),room,business,tourist);

        setRoomUnavailable(room.getRoomNumber(),checkInDate);

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

    public void setRoomUnavailable(int roomNumber, Date checkindate){

        LocalDate localDate = LocalDate.now(ZoneId.of("GMT+02:30"));
        Date currentDate = Date.valueOf(localDate);
        if(checkindate==currentDate){
            this.roomOutputPort.setReservedRoomUnavailable(roomNumber);
        }

    }

    public RoomHelper getFirstAvailableRoom(Date newReservationCheckoutDate, List<RoomHelper> roomHelpers, String businessUsername){
        LocalDate localDate = LocalDate.now(ZoneId.of("GMT+02:30"));
        Date currentDate = Date.valueOf(localDate);
       for(RoomHelper roomHelper : roomHelpers){
           Reservation reservation = this.reservationRepository.findReservationByRoomNumber(roomHelper.getRoom_number(),businessUsername, newReservationCheckoutDate, currentDate);
           if(reservation == null){
               return roomHelper;
           }
       }


        return null;
    }

    @Scheduled(fixedRate = 1000*60*60*6)
    public void updateRoomAvailability(){

        LocalDate localDate = LocalDate.now(ZoneId.of("GMT+02:30"));
        Date currentDate = Date.valueOf(localDate);
        System.out.println("Current Date is: "+currentDate);
        List<Reservation> reservations = this.reservationRepository.getAllReservationsByCheckoutDate(currentDate);
        for(Reservation r : reservations){
            RoomHelper roomHelper = this.roomOutputPort.getRoomByRoomNumber(r.getRoom().getRoomNumber());
            if(roomHelper.getIs_available()==false){
                this.roomOutputPort.setRoomAvailable(roomHelper.getRoom_number());
            }

        }


    }
    @Scheduled(fixedRate = 1000*60*60*6)
    public void updateRoomUnavailability(){
        LocalDate localDate = LocalDate.now(ZoneId.of("GMT+02:30"));
        Date currentDate = Date.valueOf(localDate);

        List<Reservation> reservations=this.reservationRepository.getAllReservationsByCheckinDate(currentDate);
        for(Reservation r : reservations){
            RoomHelper roomHelper = this.roomOutputPort.getRoomByRoomNumber(r.getRoom().getRoomNumber());
            if(roomHelper.getIs_available()==true){
                this.roomOutputPort.setReservedRoomUnavailable(roomHelper.getRoom_number());
            }
        }
    }


}

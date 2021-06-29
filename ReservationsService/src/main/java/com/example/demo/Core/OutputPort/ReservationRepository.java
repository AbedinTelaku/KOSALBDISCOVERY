package com.example.demo.Core.OutputPort;

import com.example.demo.Core.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {

    @Modifying
    @Transactional
    @Query(value = "select * from reservation where business_username=:username", nativeQuery = true)
    public List<Reservation> findReservationsByBusinessUsername(@Param("username") String username);

    @Query(value = "select * from reservation where room_type=?1 and business_username=?2", nativeQuery = true)
    public List<Reservation> findReservationsByRoomType(String roomType,String businessUsername);
}

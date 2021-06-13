package com.example.demo.Core.OutputPort;

import com.example.demo.Core.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
}

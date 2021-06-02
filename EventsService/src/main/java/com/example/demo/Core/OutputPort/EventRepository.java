package com.example.demo.Core.OutputPort;

import com.example.demo.Core.Entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Integer> {
}

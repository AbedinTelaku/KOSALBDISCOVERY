package com.example.demo.Application.InputPort;

import com.example.demo.Core.Entities.Event;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public interface EventInputport {

    void createEvent(String name, String description, Date startDate,Date endDate,String cityName,String touristPlaceName,String username);
    void deleteEventById(int id);
    Event getEventById(int id);
    List<Event> getAllEvents();



}

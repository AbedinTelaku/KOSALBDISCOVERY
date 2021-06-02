package com.example.demo.Application.InputPort;

import com.example.demo.Core.Entities.Event;

import java.util.ArrayList;
import java.util.List;


public interface EventInputport {

    void createEvent(String name, String description, String userName, String cityName, String touristPlace);
    void deleteEventById(int id);
    Event getEventById(int id);
    List<Event> getAllEvents();


}

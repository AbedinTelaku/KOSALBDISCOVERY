package com.example.demo.Core.Domain;

import com.example.demo.Core.Entities.City;
import com.example.demo.Core.Entities.TouristPlace;
import com.example.demo.Core.Entities.User;
import com.example.demo.Core.OutputPort.EventRepository;

import java.sql.Date;

public class EventDomain {

    private EventRepository eventRepository;

    public EventDomain(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void createEvent(String name, String Description, Date startDate, Date endDate, User user, City city, TouristPlace touristPlace){

    }

    // check start and end date to figure the event status

    public String setEventStatus(){
        return null;
    }

    public void updateEvent(){
        String eventStatus = setEventStatus();
        //editEvent();
    }
}

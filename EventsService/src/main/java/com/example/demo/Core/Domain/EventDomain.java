package com.example.demo.Core.Domain;

import com.example.demo.Core.Entities.City;
import com.example.demo.Core.Entities.Event;
import com.example.demo.Core.Entities.TouristPlace;
import com.example.demo.Core.Entities.User;
import com.example.demo.Core.OutputPort.EventRepository;

import java.sql.Date;

public class EventDomain {

    private EventRepository eventRepository;

    public EventDomain(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void createEvent(String name, String description,Date startDate,Date endDate ,User user, City city, TouristPlace touristPlace){

       String status = setEventStatus(startDate,endDate);

       Event event = new Event(name,description,startDate,endDate,status,user,city,touristPlace);

       this.eventRepository.save(event);
    }

    // check start and end date to figure the event status

    public String setEventStatus(Date startDate,Date endDate){
        Date currentDate = new Date(System.currentTimeMillis());

        if(endDate.equals(currentDate)){
            return "finished";
        }if(startDate.after(currentDate)){
            return "starting";
        }else{
            return "happening";
        }

    }

    public void updateEvent(){

        //editEvent();
    }
}

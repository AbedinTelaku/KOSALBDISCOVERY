package com.example.demo.Core.Services;

import com.example.demo.Application.InputPort.EventInputport;
import com.example.demo.Core.Entities.Event;
import com.example.demo.Core.OutputPort.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EventService implements EventInputport {

@Autowired
private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void createEvent(String name, String description, String userName, String cityName, String touristPlace) {


    }

    @Override
    public void deleteEventById(int id) {
        this.eventRepository.deleteById(id);

    }

    @Override
    public Event getEventById(int id) {
       Optional<Event> eventOptional= this.eventRepository.findById(id);
       return eventOptional.get();
    }

    @Override
    public List<Event> getAllEvents() {
        return this.eventRepository.findAll();
    }
}

package com.maxlvshv.greateventsback.service;

import com.maxlvshv.greateventsback.entity.EventEntity;
import com.maxlvshv.greateventsback.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    //Check how to do it better (AmigosCode -> top spring mistakes)

    public EventEntity addEvent(EventEntity event) {
        return eventRepository.save(event);
    }

    public EventEntity getEventByName(String name) {
        return eventRepository.findByName(name);
    }

    public EventEntity getEventByDate(String date) {
        return eventRepository.findByName(date);
    }

    public List<EventEntity> getAllEvents() {
        return eventRepository.findAll();
    }

    public void delEventByName(long id) {
        //
    }
}

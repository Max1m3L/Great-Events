package com.maxlvshv.greateventsback.service;

import com.maxlvshv.greateventsback.entity.EventEntity;
import com.maxlvshv.greateventsback.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public EventEntity addEvent(EventEntity event) {
        return eventRepository.save(event);
    }

    public EventEntity getEventByName(String name) {
        return eventRepository.findByName(name);
    }

    public List<EventEntity> getAllEvents() {
        return eventRepository.findAll();
    }

    public void delEventByName(long id) {
        // TODO add @DeleteMapping
    }
}

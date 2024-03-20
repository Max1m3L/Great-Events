package com.maxlvshv.greateventsback.service;

import com.maxlvshv.greateventsback.dto.EventDTO;
import com.maxlvshv.greateventsback.dto.EventDTOMapper;
import com.maxlvshv.greateventsback.entity.EventEntity;
import com.maxlvshv.greateventsback.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final EventDTOMapper eventDTOMapper;

    public EventService(EventRepository eventRepository, EventDTOMapper eventDTOMapper) {
        this.eventRepository = eventRepository;
        this.eventDTOMapper = eventDTOMapper;
    }

    public EventEntity addEvent(EventEntity event) {
        return eventRepository.save(event);
    }

    public EventDTO getEventByName(String name) {
        return eventRepository.findByName(name)
                .map(eventDTOMapper)
                .orElseThrow(() -> new RuntimeException("wrong"));
    }

    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll().stream().
                map(eventDTOMapper).
                collect(Collectors.toList());
    }

    public void delEventByName(long id) {
        // TODO add @DeleteMapping
    }
}

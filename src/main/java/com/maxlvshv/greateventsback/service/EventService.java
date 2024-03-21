package com.maxlvshv.greateventsback.service;

import com.maxlvshv.greateventsback.dto.EventDTO;
import com.maxlvshv.greateventsback.dto.EventDTOMapper;
import com.maxlvshv.greateventsback.entity.EventEntity;
import com.maxlvshv.greateventsback.exception.EventAlreadyExistException;
import com.maxlvshv.greateventsback.exception.EventNotFoundException;
import com.maxlvshv.greateventsback.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final EventDTOMapper eventDTOMapper;


    public EventDTO getEventByName(String name) {
        return eventRepository.findByName(name)
                .map(eventDTOMapper)
                .orElseThrow(() -> new RuntimeException("Some problems"));
    }

    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(eventDTOMapper)
                .collect(Collectors.toList());
    }

    public void addEvent(EventEntity event) throws EventAlreadyExistException {
        if (eventRepository.findByName(event.getName()).isPresent() &&
                eventRepository.findByPlace(event.getPlace()).isPresent()) {

            throw new EventAlreadyExistException("The same event already exist");
        }

        eventRepository.save(event);
    }

    public void deleteEvent(Long id) throws EventNotFoundException {
        if (!eventRepository.existsById(id))
            throw new EventNotFoundException("Event not found");

        eventRepository.deleteById(id);
    }
}

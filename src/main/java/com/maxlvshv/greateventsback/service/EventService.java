package com.maxlvshv.greateventsback.service;

import com.maxlvshv.greateventsback.dto.EventDTO;
import com.maxlvshv.greateventsback.dto.EventDTOMapper;
import com.maxlvshv.greateventsback.entity.EventEntity;
import com.maxlvshv.greateventsback.exception.EventAlreadyExistException;
import com.maxlvshv.greateventsback.exception.EventNotFoundException;
import com.maxlvshv.greateventsback.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final EventDTOMapper eventDTOMapper;

    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(eventDTOMapper)
                .collect(Collectors.toList());
    }

    public EventDTO getEventByName(String name) throws EventNotFoundException {
        return eventRepository.findByName(name)
                .map(eventDTOMapper)
                .orElseThrow(() -> new EventNotFoundException("Some problems"));
    }

    public EventEntity getEventByNameWithId(String name) throws EventNotFoundException {
        return eventRepository.findByName(name)
                .orElseThrow(() -> new EventNotFoundException("Some problems"));
    }

    public void addEvent(EventEntity event) {
        if (eventRepository.findByName(event.getName()).isPresent() &&
                eventRepository.findByPlace(event.getPlace()).isPresent()) {
            Exception exception = new EventAlreadyExistException();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "User Already exist", exception);
        }

        eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        if (!eventRepository.existsById(id)) {
            Exception exception = new EventNotFoundException("");
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Is isn't event with this id", exception);
        }

        eventRepository.deleteById(id);
    }
}

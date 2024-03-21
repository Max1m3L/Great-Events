package com.maxlvshv.greateventsback.controller;

import com.maxlvshv.greateventsback.entity.EventEntity;
import com.maxlvshv.greateventsback.exception.EventAlreadyExistException;
import com.maxlvshv.greateventsback.exception.EventNotFoundException;
import com.maxlvshv.greateventsback.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping
    public ResponseEntity<?> getAllEvents() {
        try {
            return ResponseEntity.ok(eventService.getAllEvents());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("Some problem: " + exception);
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getEventByName(@PathVariable("name") String name) {
        try {
            return ResponseEntity.ok(eventService.getEventByName(name));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("Some problem: " + exception);
        }
    }

    @PostMapping("/new")
    public void addEvent(@RequestBody EventEntity event) throws EventAlreadyExistException {
        eventService.addEvent(event);
    }

    @DeleteMapping(path = "{eventId}")
    public void deleteEvent(@PathVariable(value = "eventId") Long id) throws EventNotFoundException {
        eventService.deleteEvent(id);
    }
}

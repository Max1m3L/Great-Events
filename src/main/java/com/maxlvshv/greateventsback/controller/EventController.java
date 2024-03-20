package com.maxlvshv.greateventsback.controller;

import com.maxlvshv.greateventsback.entity.EventEntity;
import com.maxlvshv.greateventsback.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewEvent(@RequestBody EventEntity event) {
        try {
            return ResponseEntity.ok(eventService.addEvent(event));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("Some problem: " + exception);
        }
    }

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

//    @DeleteMapping("/{name}")
//    public ResponseEntity<?> delEventByName(@PathVariable("name") String name) {
//        try {
//            return ResponseEntity.ok(eventService.);
//        } catch (Exception exception) {
//            return ResponseEntity.badRequest().body("Some problem: " + exception);
//        }
//    }
}

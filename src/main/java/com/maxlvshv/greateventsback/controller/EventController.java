package com.maxlvshv.greateventsback.controller;

import com.maxlvshv.greateventsback.dto.MessageRequest;
import com.maxlvshv.greateventsback.entity.EventEntity;
import com.maxlvshv.greateventsback.exception.EventNotFoundException;
import com.maxlvshv.greateventsback.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class EventController {

    private final EventService eventService;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping
    public ResponseEntity<?> getAllEvents() {
        try {
            return ResponseEntity.ok(eventService.getAllEvents());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception);
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getEventByName(@PathVariable("name") String name) throws EventNotFoundException {
        return ResponseEntity.ok(eventService.getEventByName(name));
    }

    @GetMapping("/{name}/id")
    public EventEntity getEventByNameWithId(@PathVariable("name") String name) throws EventNotFoundException {
        return eventService.getEventByNameWithId(name);
    }

    @PostMapping("/new")
    public String addEvent(@RequestBody EventEntity event) {
        eventService.addEvent(event);
        return "OK";
    }

    @DeleteMapping(path = "{eventId}")
    public String deleteEvent(@PathVariable(value = "eventId") Long id) {
        eventService.deleteEvent(id);
        return "OK";
    }

    // For kafka
    @PostMapping("/api/v1")
    public void publish(@RequestBody MessageRequest request) {
        kafkaTemplate.send("NewTopic", request.message());
    }
}

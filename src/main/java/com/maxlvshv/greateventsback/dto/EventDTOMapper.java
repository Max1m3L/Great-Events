package com.maxlvshv.greateventsback.dto;

import com.maxlvshv.greateventsback.entity.EventEntity;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class EventDTOMapper implements Function<EventEntity, EventDTO> {
    @Override
    public EventDTO apply(EventEntity event) {
        return new EventDTO(
                event.getName(),
                event.getPlace(),
                event.getDescription()
        );
    }
}

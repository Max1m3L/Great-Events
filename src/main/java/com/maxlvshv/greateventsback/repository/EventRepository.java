package com.maxlvshv.greateventsback.repository;

import com.maxlvshv.greateventsback.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {
    EventEntity findByName(String name);

    //TODO add DTO instead of entity
}

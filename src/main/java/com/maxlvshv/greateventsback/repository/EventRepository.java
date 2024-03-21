package com.maxlvshv.greateventsback.repository;

import com.maxlvshv.greateventsback.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {
    Optional<EventEntity> findByName(String name);

    Optional<EventEntity> findByPlace(String place);
}

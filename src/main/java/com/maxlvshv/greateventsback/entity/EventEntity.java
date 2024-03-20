package com.maxlvshv.greateventsback.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Events")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String place;
    @Column
    private String description;

}

package com.ph.juy.springboot.playground.repository.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
@Entity
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    @Column(name = "created_at")
    private Instant createdAt;

}

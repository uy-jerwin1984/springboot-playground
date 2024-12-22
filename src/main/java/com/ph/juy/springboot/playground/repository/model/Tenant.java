package com.ph.juy.springboot.playground.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.util.UUID;

@Data
@Entity
public class Tenant {

    @Id
    private UUID id;
    private String name;
    @Column(name = "created_at")
    private Instant createdAt;

}

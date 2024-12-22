package com.ph.juy.springboot.playground.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.util.UUID;

@Data
@Entity(name = "object_definition")
public class ObjectDefinition {

    @Id
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;
    private String name;
    private String label;
    @Column(name = "created_at")
    private Instant createdAt;
}

package com.ph.juy.springboot.playground.repository.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
@Entity(name = "field_definition")
public class FieldDefinition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;
    @ManyToOne
    @JoinColumn(name = "object_definition_id", nullable = false)
    private ObjectDefinition objectDefinition;
    @Column(name = "field_name")
    private String name;
    @Column(name = "field_type")
    @Enumerated(EnumType.STRING)
    private FieldType fieldType;
    @Column(name = "default_value")
    private String defaultValue;
    @Column(name = "created_at")
    private Instant createdAt;

}

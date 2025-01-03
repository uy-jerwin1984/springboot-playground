package com.ph.juy.springboot.playground.repository.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "object_definition")
public class ObjectDefinition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;
    private String name;
    private String label;
    @Column(name = "created_at")
    private Instant createdAt;
    @OneToMany(mappedBy = "objectDefinition", cascade = CascadeType.ALL)
    private List<FieldDefinition> fieldDefinitions;

    @PrePersist
    public void propagate() {
        if (fieldDefinitions != null) {
            final ObjectDefinition copy = new ObjectDefinition();
            fieldDefinitions.forEach(e -> {
                e.setCreatedAt(Instant.now());
                e.setTenant(this.getTenant());
                e.setObjectDefinition(this);
            });
        }
    }

}

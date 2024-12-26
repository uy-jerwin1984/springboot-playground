package com.ph.juy.springboot.playground.service;

import com.ph.juy.springboot.playground.repository.ObjectDefinitionRepository;
import com.ph.juy.springboot.playground.repository.model.ObjectDefinition;
import com.ph.juy.springboot.playground.repository.model.Tenant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ObjectDefinitionService {

    private final ObjectDefinitionRepository objectDefinitionRepository;
    private final TenantService tenantService;

    public ObjectDefinition create(final ObjectDefinition objectDefinition) {
        final Tenant tenant = objectDefinition.getTenant();
        if (tenant == null || tenant.getId() == null) {
            throw new IllegalArgumentException();
        }
        final Optional<Tenant> resolvedTenant = tenantService.findById(tenant.getId());
        if (resolvedTenant.isEmpty()) {
            throw new IllegalArgumentException();
        }
        objectDefinition.setCreatedAt(Instant.now());
        return objectDefinitionRepository.save(objectDefinition);
    }

}

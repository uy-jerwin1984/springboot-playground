package com.ph.juy.springboot.playground.service;

import com.ph.juy.springboot.playground.repository.ObjectDefinitionRepository;
import com.ph.juy.springboot.playground.repository.model.ObjectDefinition;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ObjectDefinitionService {

    private final ObjectDefinitionRepository objectDefinitionRepository;
    private final TenantService tenantService;

    public ObjectDefinition create(final ObjectDefinition objectDefinition) {
        return null;
    }

}

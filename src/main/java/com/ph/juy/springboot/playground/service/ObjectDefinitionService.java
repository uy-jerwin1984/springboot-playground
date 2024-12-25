package com.ph.juy.springboot.playground.service;

import com.ph.juy.springboot.playground.repository.ObjectDefinitionRepository;
import com.ph.juy.springboot.playground.repository.model.ObjectDefinition;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ObjectDefinitionService {

    private final ObjectDefinitionRepository objectDefinitionRepository;
    private final TenantService tenantService;

    public Mono<ObjectDefinition> create(final ObjectDefinition objectDefinition) {
        final Mono<ObjectDefinition> result = tenantService.find(objectDefinition.getTenant())
                .flatMap(tenant -> {
                    System.out.println("ObjectDefinitionService > " + tenant);
                    System.out.println("ObjectDefinitionService > " + objectDefinition);
                    return objectDefinitionRepository.save(objectDefinition);
                });
        result.subscribe(r -> {
            System.out.println("ObjectDefinitionService > " + r);
        });
        return result;
    }

}

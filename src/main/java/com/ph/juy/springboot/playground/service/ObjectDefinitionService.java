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

    public Mono<ObjectDefinition> create(final ObjectDefinition objectDefinition) {
        return objectDefinitionRepository.save(objectDefinition);
    }

}

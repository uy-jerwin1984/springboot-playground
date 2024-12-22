package com.ph.juy.springboot.playground.repository;

import com.ph.juy.springboot.playground.repository.model.ObjectDefinition;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ObjectDefinitionRepository extends R2dbcRepository<ObjectDefinition, UUID> {

}

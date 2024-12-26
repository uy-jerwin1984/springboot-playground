package com.ph.juy.springboot.playground.repository;

import com.ph.juy.springboot.playground.repository.model.ObjectDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ObjectDefinitionRepository extends JpaRepository<ObjectDefinition, UUID> {

}

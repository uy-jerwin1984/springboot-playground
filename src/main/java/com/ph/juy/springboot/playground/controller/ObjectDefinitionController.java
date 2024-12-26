package com.ph.juy.springboot.playground.controller;

import com.ph.juy.springboot.playground.repository.model.ObjectDefinition;
import com.ph.juy.springboot.playground.service.ObjectDefinitionService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/object_definitions")
@AllArgsConstructor
public class ObjectDefinitionController {

    private final ObjectDefinitionService objectDefinitionService;

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ObjectDefinition> create(@RequestBody ObjectDefinition objectDefinition) {
        return ResponseEntity.badRequest().build();
    }

}

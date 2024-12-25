package com.ph.juy.springboot.playground.controller;

import com.ph.juy.springboot.playground.repository.model.Tenant;
import com.ph.juy.springboot.playground.service.TenantService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.UUID;

@RestController
@RequestMapping("/tenants")
@AllArgsConstructor
public class TenantController {

    private final TenantService tenantService;

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public Mono<Tenant> create(@RequestBody Tenant tenant) {
        tenant.setCreatedAt(Instant.now());
        return tenantService.create(tenant);
    }

    @GetMapping(
            path = { "/{id}"},
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public Mono<ResponseEntity<Tenant>> findById(@PathVariable("id") UUID id) {
        return tenantService.findById(id)
                .checkpoint("tenantService.findById", true)
                .map(ResponseEntity::ok)
                .checkpoint("switchIfEmpty", true)
                .switchIfEmpty(Mono.just(ResponseEntity.badRequest().build()));
    }

}

package com.ph.juy.springboot.playground.controller;

import com.ph.juy.springboot.playground.repository.model.Tenant;
import com.ph.juy.springboot.playground.service.TenantService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Tenant> create(@RequestBody Tenant tenant) {
        tenant.setCreatedAt(Instant.now());
        return ResponseEntity.ok(tenantService.create(tenant));
    }

    @GetMapping(
            path = { "/{id}"},
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Tenant> findById(@PathVariable("id") UUID id) {
        return tenantService.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

}

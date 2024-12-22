package com.ph.juy.springboot.playground.controller;

import com.ph.juy.springboot.playground.repository.model.Tenant;
import com.ph.juy.springboot.playground.service.TenantService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/tenants")
@AllArgsConstructor
public class TenantController {

    private final TenantService tenantService;
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public Mono<Tenant> create(@RequestBody Tenant tenant) {
        return tenantService.create(tenant);
    }

}

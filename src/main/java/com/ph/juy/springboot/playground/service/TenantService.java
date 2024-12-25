package com.ph.juy.springboot.playground.service;

import com.ph.juy.springboot.playground.repository.TenantRepository;
import com.ph.juy.springboot.playground.repository.model.Tenant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@AllArgsConstructor
public class TenantService {

    private final TenantRepository tenantRepository;

    public Mono<Tenant> create(final Tenant tenant) {
        return tenantRepository.save(tenant);
    }

    public Mono<Tenant> find(final Tenant tenant) {
        final UUID tenantId = tenant.getId();
        return tenantRepository.findById(tenantId).defaultIfEmpty(new Tenant());
    }

    public Mono<Tenant> findById(final UUID uuid) {
        return tenantRepository.findById(uuid);
    }

}

package com.ph.juy.springboot.playground.service;

import com.ph.juy.springboot.playground.repository.TenantRepository;
import com.ph.juy.springboot.playground.repository.model.Tenant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class TenantService {

    private final TenantRepository tenantRepository;

    public Mono<Tenant> create(final Tenant tenant) {
        return tenantRepository.save(tenant);
    }

}

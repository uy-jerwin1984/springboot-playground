package com.ph.juy.springboot.playground.service;

import com.ph.juy.springboot.playground.repository.TenantRepository;
import com.ph.juy.springboot.playground.repository.model.Tenant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TenantService {

    private final TenantRepository tenantRepository;

    public Tenant create(final Tenant tenant) {
        return tenantRepository.save(tenant);
    }

    public Optional<Tenant> find(final Tenant tenant) {
        final UUID tenantId = tenant.getId();
        return tenantRepository.findById(tenantId);
    }

    public Optional<Tenant> findById(final UUID uuid) {
        return tenantRepository.findById(uuid);
    }

}

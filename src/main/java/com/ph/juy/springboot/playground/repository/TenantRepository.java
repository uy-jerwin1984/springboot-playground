package com.ph.juy.springboot.playground.repository;

import com.ph.juy.springboot.playground.repository.model.Tenant;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TenantRepository extends R2dbcRepository<Tenant, UUID>  {

}

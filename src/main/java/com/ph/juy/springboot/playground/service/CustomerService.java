package com.ph.juy.springboot.playground.service;

import com.ph.juy.springboot.playground.repository.CustomerRepository;
import com.ph.juy.springboot.playground.repository.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Mono<Customer> create(final Customer customer) {
        //customer.setId(UUID.randomUUID().toString());
        customer.setName(UUID.randomUUID().toString());
        return customerRepository.save(customer);
    }

    public Mono<Customer> findById(final UUID id) {
        return customerRepository.findById(id);
    }
}

package com.ph.juy.springboot.playground.service;

import com.ph.juy.springboot.playground.repository.CustomerRepository;
import com.ph.juy.springboot.playground.repository.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer create(final Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> findById(final UUID id) {
        return customerRepository.findById(id);
    }

}

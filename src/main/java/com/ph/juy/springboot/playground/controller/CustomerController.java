package com.ph.juy.springboot.playground.controller;

import com.ph.juy.springboot.playground.repository.model.Customer;
import com.ph.juy.springboot.playground.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        final Customer result = customerService.create(customer);
        return ResponseEntity.ok(result);
    }
    
    @GetMapping(path = { "/{id}"},
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Customer> findById(@PathVariable("id") UUID id) {
        final Optional<Customer> customer = customerService.findById(id);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

}

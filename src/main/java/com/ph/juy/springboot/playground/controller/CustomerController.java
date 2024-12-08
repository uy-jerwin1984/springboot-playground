package com.ph.juy.springboot.playground.controller;

import com.ph.juy.springboot.playground.repository.model.Customer;
import com.ph.juy.springboot.playground.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public Mono<Customer> create(@RequestBody Customer customer) {
        return customerService.create(customer);
    }

    @GetMapping(path = { "/{id}"},
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public Mono<ResponseEntity<Customer>> findById(@PathVariable("id") UUID id) {
        return customerService.findById(id).flatMap(customer -> customer != null ? Mono.just(ResponseEntity.ok(customer)) : Mono.just(ResponseEntity.badRequest().build()));
    }

}

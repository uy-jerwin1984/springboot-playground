package com.ph.juy.springboot.playground.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/app-info")
public class AppInfoController {

    @GetMapping
    public Mono<String> appInfo() {
        return Mono.just(UUID.randomUUID().toString());
    }

}

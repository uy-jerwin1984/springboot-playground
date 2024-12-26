package com.ph.juy.springboot.playground.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/app-info")
public class AppInfoController {

    @GetMapping
    public String appInfo() {
        return UUID.randomUUID().toString();
    }

}

package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class InfoController {

    @GetMapping("/info")
    public Map<String, Object> getInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("message", "Welcome to Spring Boot with Spring Security!");
        info.put("timestamp", LocalDateTime.now());
        info.put("version", "1.0.0");
        info.put("status", "running");
        info.put("description", "This is a protected API endpoint that requires authentication");
        return info;
    }

    @GetMapping("/public/health")
    public Map<String, Object> getHealth() {
        Map<String, Object> health = new HashMap<>();
        health.put("status", "UP");
        health.put("timestamp", LocalDateTime.now());
        health.put("service", "spring-sec-minus-crypto");
        return health;
    }
} 
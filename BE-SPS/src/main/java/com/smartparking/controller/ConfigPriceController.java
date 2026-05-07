package com.smartparking.controller;

import com.smartparking.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.smartparking.service.ConfigPriceService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/config-price")

public class ConfigPriceController {

    @Autowired
    private ConfigPriceService service;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAllConfigs());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ConfigPrice config) {
        return ResponseEntity.ok(service.create(config));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ConfigPrice config) {
        return ResponseEntity.ok(service.update(id, config));
    }
}

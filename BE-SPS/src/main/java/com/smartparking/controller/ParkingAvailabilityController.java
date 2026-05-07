package com.smartparking.controller;

import com.smartparking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/availability")
public class ParkingAvailabilityController {

    @Autowired
    private ParkingAvailabilityService service;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAvailability());
    }
}

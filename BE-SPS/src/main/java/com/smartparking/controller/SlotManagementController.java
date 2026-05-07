package com.smartparking.controller;

import com.smartparking.entity.*;
import com.smartparking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/slots")
public class SlotManagementController {

    @Autowired
    private SlotService service;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ParkingSlot slot) {
        return ResponseEntity.ok(service.create(slot));
    }
}

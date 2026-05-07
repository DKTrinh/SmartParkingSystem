package com.smartparking.controller;

import com.smartparking.dto.*;
import com.smartparking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PaymentRequest request) {
        return ResponseEntity.ok(service.createPayment(request));
    }

    @PostMapping("/{id}/pay")
    public ResponseEntity<?> pay(@PathVariable Long id) {
        return ResponseEntity.ok(service.pay(id));
    }
}

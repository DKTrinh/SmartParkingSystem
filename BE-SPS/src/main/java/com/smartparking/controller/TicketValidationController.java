package com.smartparking.controller;

import com.smartparking.dto.*;
import com.smartparking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/tickets")
public class TicketValidationController {

    @Autowired
    private TicketService service;

    @PostMapping("/validate")
    public ResponseEntity<?> validate(@RequestBody TicketRequest request) {
        return ResponseEntity.ok(service.validate(request));
    }
}

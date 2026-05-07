package com.smartparking.controller;

import com.smartparking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService service;

    @GetMapping("/revenue")
    public ResponseEntity<?> revenue() {
        return ResponseEntity.ok(service.getRevenue());
    }

    @GetMapping("/usage")
    public ResponseEntity<?> usage() {
        return ResponseEntity.ok(service.getUsage());
    }
}

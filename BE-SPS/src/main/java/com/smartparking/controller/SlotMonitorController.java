package com.smartparking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.smartparking.service.MonitorService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/monitor")
public class SlotMonitorController {

    @Autowired
    private MonitorService service;

    @GetMapping("/slots")
    public ResponseEntity<?> monitorSlots() {
        return ResponseEntity.ok(service.getRealtimeSlots());
    }
}

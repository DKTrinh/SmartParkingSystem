package com.smartparking.controller;

import com.smartparking.dto.*;
import com.smartparking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/iot")
public class IOTManagementController {

    @Autowired
    private IOTService service;

    @PostMapping("/update-slot")
    public ResponseEntity<?> updateSlot(@RequestBody IOTRequest request) {
        service.updateSlotStatus(request);
        return ResponseEntity.ok("Updated");
    }
}

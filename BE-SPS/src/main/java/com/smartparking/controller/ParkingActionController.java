package com.smartparking.controller;

import com.smartparking.dto.*;
import com.smartparking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/parking")
public class ParkingActionController {

    @Autowired
    private ParkingService service;

    // check-in (quẹt thẻ vào)
    @PostMapping("/check-in")
    public ResponseEntity<?> checkIn(@RequestBody CheckInRequest request) {
        return ResponseEntity.ok(service.enterParking(request.getCardId()));
    }

    // check-out (ra)
    @PostMapping("/check-out")
    public ResponseEntity<?> checkOut(@RequestBody CheckOutRequest request) {
        return ResponseEntity.ok(service.exitParking(request.getCardId()));
    }
}

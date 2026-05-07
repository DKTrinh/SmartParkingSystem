package com.smartparking.service;

import com.smartparking.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smartparking.entity.enums.ParkingSlotStatus;
import java.util.Map;

@Service
public class ParkingAvailabilityService {

    @Autowired
    private ParkingSlotRepository slotRepo;

    public Map<String, Long> getAvailability() {

        long available = slotRepo.countByStatus(ParkingSlotStatus.AVAILABLE);
        long occupied = slotRepo.countByStatus(ParkingSlotStatus.OCCUPIED);

        return Map.of(
                "available", available,
                "occupied", occupied);
    }
}
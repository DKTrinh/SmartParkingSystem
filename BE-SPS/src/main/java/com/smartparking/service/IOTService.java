package com.smartparking.service;

import com.smartparking.entity.*;
import com.smartparking.dto.*;
import com.smartparking.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IOTService {

    @Autowired
    private ParkingSlotRepository slotRepo;

    public void updateSlotStatus(IOTRequest req) {

        ParkingSlot slot = slotRepo.findById(req.getSlotId())
                .orElseThrow();

        slot.setOccupied(req.isOccupied());

        slotRepo.save(slot);
    }
}
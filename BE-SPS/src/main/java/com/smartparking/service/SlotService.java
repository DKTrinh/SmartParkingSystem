package com.smartparking.service;
import com.smartparking.entity.*;
import com.smartparking.repository.*;
import com.smartparking.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SlotService {

    @Autowired private ParkingSlotRepository slotRepo;
    @Autowired private ParkingLotRepository lotRepo;

    public List<ParkingSlotResponse> getAll() {
        return slotRepo.findAll()
                .stream()
                .map(slot -> new ParkingSlotResponse(
                        slot.getId(),
                        slot.getName(),
                        slot.getStatus().name(),
                        slot.getParkinglot().getId()
                ))
                .toList();
    }

    public ParkingSlotResponse create(ParkingSlot slot) {

        ParkingLot lot = lotRepo.findById(slot.getParkinglot().getId())
                .orElseThrow(() -> new RuntimeException("Parking lot not found"));

        slot.setParkinglot(lot);

        ParkingSlot saved = slotRepo.save(slot);

        return new ParkingSlotResponse(
                saved.getId(),
                saved.getName(),
                saved.getStatus().name(),
                saved.getParkinglot().getId()
        );
    }
}
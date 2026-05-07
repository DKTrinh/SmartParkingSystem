package com.smartparking.service;

import com.smartparking.dto.SlotMonitorResponse;
import com.smartparking.entity.*;
import com.smartparking.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MonitorService {

    @Autowired
    private ParkingSlotRepository repo;

    public List<SlotMonitorResponse> getRealtimeSlots() {

        return repo.findAll()
                .stream()
                .map(slot -> new SlotMonitorResponse(
                        slot.getId(),
                        slot.getName(),
                        slot.getStatus().name(),
                        slot.getParkinglot().getName()
                ))
                .toList();
    }
}
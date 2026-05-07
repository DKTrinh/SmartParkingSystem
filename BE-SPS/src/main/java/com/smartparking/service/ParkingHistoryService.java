package com.smartparking.service;

import com.smartparking.dto.ParkingHistoryResponse;
import com.smartparking.entity.ParkingSession;
import com.smartparking.repository.ParkingSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingHistoryService {

    @Autowired
    private ParkingSessionRepository sessionRepository;

    public List<ParkingHistoryResponse> getByUser(Long userId) {

        List<ParkingSession> sessions = sessionRepository.findByUserId(userId);

        return sessions.stream()
<<<<<<< HEAD
                .map(s -> new ParkingHistoryResponse(
                        s.getId(),
                        s.getSlot().getName(),
                        s.getVehicle().getPlateNumber(),
                        s.getVehicle().getType().name(),
                        s.getEntryTime(),
                        s.getExitTime(),
                        s.getStatus().name()
=======
                .map(session -> new ParkingHistoryResponse(
                        session.getId(),
                        session.getVehicle().getPlatenumber(),
                        session.getSlot().getName(),
                        session.getEntryTime(),
                        session.getExitTime(),
                        session.getStatus().name()
>>>>>>> 476876e (integrate APIs for parking history and payment modules)
                ))
                .toList();
    }
}
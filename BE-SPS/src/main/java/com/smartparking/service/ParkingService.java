package com.smartparking.service;

import com.smartparking.dto.CheckInResponse;
import com.smartparking.dto.CheckOutResponse;
import com.smartparking.entity.*;
import com.smartparking.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import com.smartparking.entity.enums.ParkingStatus;
import com.smartparking.entity.enums.ParkingSlotStatus;

@Service
public class ParkingService {

        private final UserRepository userRepository;
        private final ParkingSlotRepository slotRepository;
        private final ParkingSessionRepository sessionRepository;

        public ParkingService(UserRepository userRepository,
                        ParkingSlotRepository slotRepository,
                        ParkingSessionRepository sessionRepository) {
                this.userRepository = userRepository;
                this.slotRepository = slotRepository;
                this.sessionRepository = sessionRepository;
        }

        public CheckInResponse enterParking(String cardId) {

                User user = userRepository.findByCardId(cardId)
                        .orElseThrow(() -> new RuntimeException("User not found"));

                ParkingSlot slot = slotRepository.findFirstByStatus(ParkingSlotStatus.AVAILABLE)
                        .orElseThrow(() -> new RuntimeException("Parking full"));

                slot.setOccupied(true);
                slotRepository.save(slot);

                ParkingSession session = new ParkingSession();
                session.setEntryTime(LocalDateTime.now());
                session.setStatus(ParkingStatus.ACTIVE);
                session.setUser(user);
                session.setSlot(slot);

                sessionRepository.save(session);

                return new CheckInResponse(
                        session.getId(),
                        slot.getName(),
                        "Check-in success"
                );
        }

        public CheckOutResponse exitParking(String cardId) {

                User user = userRepository.findByCardId(cardId)
                        .orElseThrow(() -> new RuntimeException("User not found"));

                ParkingSession session = sessionRepository
                        .findFirstByUserAndStatus(user, ParkingStatus.ACTIVE)
                        .orElseThrow(() -> new RuntimeException("No active session"));

                session.setExitTime(LocalDateTime.now());
                session.setStatus(ParkingStatus.FINISHED);

                ParkingSlot slot = session.getSlot();
                slot.setOccupied(false);

                slotRepository.save(slot);
                sessionRepository.save(session);

                return new CheckOutResponse(
                        session.getId(),
                        slot.getName(),
                        "Check-out success"
                );
        }
}
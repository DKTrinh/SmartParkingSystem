package com.smartparking.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.smartparking.entity.ParkingSession;
import com.smartparking.entity.User;
import com.smartparking.entity.enums.ParkingStatus;

import java.util.Optional;

public interface ParkingSessionRepository extends JpaRepository<ParkingSession, Long> {

    Optional<ParkingSession> findFirstByStatus(ParkingStatus status);

    Optional<ParkingSession> findFirstByUserAndStatus(User user, ParkingStatus status);

    List<ParkingSession> findByUserId(Long userId);
}

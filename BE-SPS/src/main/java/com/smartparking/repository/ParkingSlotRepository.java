package com.smartparking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartparking.entity.ParkingSlot;
import com.smartparking.entity.enums.ParkingSlotStatus;

import java.util.List;
import java.util.Optional;

public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Long> {

    Optional<ParkingSlot> findFirstByStatus(ParkingSlotStatus status);

    long countByStatus(ParkingSlotStatus status);

    List<ParkingSlot> findByParkinglotId(Long parkingLotId);
}
package com.smartparking.repository;

import java.util.List;
import com.smartparking.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByUserId(Long userId);
}

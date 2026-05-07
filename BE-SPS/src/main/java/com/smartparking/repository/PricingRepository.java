package com.smartparking.repository;

import com.smartparking.entity.Pricing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PricingRepository extends JpaRepository<Pricing, Long> {

    List<Pricing> findByVehicleType(String vehicleType);

}
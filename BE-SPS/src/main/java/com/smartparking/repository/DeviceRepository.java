package com.smartparking.repository;

import com.smartparking.entity.Device;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    @Query("SELECT d FROM Device d WHERE d.type LIKE %:keyword%")
    List<Device> searchDevices(@Param("keyword") String keyword);
}
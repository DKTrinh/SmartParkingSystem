package com.smartparking.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParkingHistoryResponse {
    private Long sessionId;
    private String plateNumber;
    private String slotName;
    private String plateNumber;
    private String vehicleType;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private String status;
}
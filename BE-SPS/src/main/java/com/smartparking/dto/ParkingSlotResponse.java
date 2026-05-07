package com.smartparking.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSlotResponse {
    private Long id;
    private String name;
    private String status;
    private Long parkingLotId;
}

package com.smartparking.dto;
import java.time.LocalDateTime;
import lombok.*;

@Data
@AllArgsConstructor
public class ParkingLotResponse {
    private Long id;
    private String name;
    private String location;
}

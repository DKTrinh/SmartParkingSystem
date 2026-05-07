package com.smartparking.dto;
import lombok.*;

@Data
@AllArgsConstructor
public class CreateParkingLotRequest {
    private String name;
    private String location;
}

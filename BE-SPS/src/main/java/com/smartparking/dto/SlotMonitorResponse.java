package com.smartparking.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SlotMonitorResponse {
    private Long slotId;
    private String slotName;
    private String status;
    private String parkingLotName;
}

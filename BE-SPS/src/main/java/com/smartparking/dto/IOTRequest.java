package com.smartparking.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IOTRequest {
    private Long slotId;
    private boolean occupied;
}

package com.smartparking.entity;

import jakarta.persistence.*;
import lombok.*;
import com.smartparking.entity.enums.DeviceType;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DeviceType type;

    private LocalDateTime last_seen;

    @OneToOne
    @JoinColumn(name = "slot_id")
    private ParkingSlot parkingSlot;
}
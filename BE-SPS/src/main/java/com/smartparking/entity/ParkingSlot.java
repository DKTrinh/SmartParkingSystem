package com.smartparking.entity;

import jakarta.persistence.*;
import lombok.*;
import com.smartparking.entity.enums.ParkingSlotStatus;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ParkingSlotStatus status = ParkingSlotStatus.AVAILABLE;

    @ManyToOne
    @Enumerated(EnumType.STRING)
    private ParkingLot parkinglot;

    public Long getId() {
        return id;
    }

    public boolean isOccupied() {
        return this.status == ParkingSlotStatus.OCCUPIED;
    }

    public void setOccupied(boolean occupied) {
        this.status = occupied ? ParkingSlotStatus.OCCUPIED : ParkingSlotStatus.AVAILABLE;
    }
}
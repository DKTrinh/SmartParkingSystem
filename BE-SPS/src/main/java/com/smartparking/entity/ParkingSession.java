package com.smartparking.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import com.smartparking.entity.enums.ParkingStatus;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime entryTime;

    private LocalDateTime exitTime;

    @Enumerated(EnumType.STRING)
    private ParkingStatus status; // ACTIVE, FINISHED

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private ParkingSlot slot;

    @ManyToOne(fetch = FetchType.EAGER)
    private Vehicle vehicle;

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public void setStatus(ParkingStatus status) {
        this.status = status;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSlot(ParkingSlot slot) {
        this.slot = slot;
    }

    public ParkingSlot getSlot() {
        return slot;
    }
}
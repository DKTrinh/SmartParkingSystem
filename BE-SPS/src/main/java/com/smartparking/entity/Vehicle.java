package com.smartparking.entity;

import jakarta.persistence.*;
import lombok.*;
import com.smartparking.entity.enums.VehicleType;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "platenumber")
    private String plateNumber;

    @Enumerated(EnumType.STRING)
    private VehicleType type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "vehicle")
    private List<ParkingSession> parkingSessions;
}

package com.smartparking.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import com.smartparking.entity.enums.PricingType;
import com.smartparking.entity.enums.VehicleType;

@Entity
@Table(name = "pricing")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pricing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PricingType type; // HOURLY / DAILY / MONTHLY

    private Double pricePerHour;

    private Double pricePerDay;

    private Double pricePerMonth;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType; // CAR / BIKE

    private LocalDateTime createdAt;
}
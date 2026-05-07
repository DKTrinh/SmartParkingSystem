package com.smartparking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime start_date;

    private LocalDateTime end_date;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}

package com.smartparking.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized; // <-- Bổ sung thư viện này
import com.smartparking.entity.enums.UserRole;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nationalized // <-- Lệnh ép SQL Server dùng kiểu NVARCHAR để lưu tiếng Việt
    private String name;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private LocalDateTime createdAt = LocalDateTime.now();

    private String cardId;

    private String email;

    @OneToMany(mappedBy = "user")
    private List<Vehicle> vehicles;

    @OneToMany(mappedBy = "user")
    private List<Payment> payments;

    public String getName() {
        return this.name;
    }
}
package com.smartparking.dto;

import java.time.LocalDateTime;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String name;
    private String role;
    private String cardId;
    private String email;
    private LocalDateTime createdAt;
}

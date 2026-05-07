package com.smartparking.dto;

import java.math.BigDecimal;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentPayResponse {
    private Long id;
    private BigDecimal amount;
    private String status;
    private String message;
}

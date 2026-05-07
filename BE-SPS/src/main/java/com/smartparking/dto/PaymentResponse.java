package com.smartparking.dto;
import java.math.BigDecimal;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {
    private Long id;
    private BigDecimal amount;
    private String status;
    private List<Long> sessionIds;
}

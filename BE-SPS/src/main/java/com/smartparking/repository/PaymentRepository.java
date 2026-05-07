package com.smartparking.repository;

import com.smartparking.entity.*;
import java.util.*;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("SELECT SUM(p.amount) FROM Payment p WHERE p.status = 'PAID'")
    BigDecimal sumAllPaid();

    List<Payment> findByUserId(Long userId);
}

package com.smartparking.service;

import com.smartparking.entity.*;
import com.smartparking.dto.*;
import com.smartparking.repository.*;
import java.util.*;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Duration;
import com.smartparking.entity.enums.PaymentStatus;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepo;
    @Autowired
    private ParkingSessionRepository sessionRepo;

    public PaymentResponse createPayment(PaymentRequest request) {

        List<ParkingSession> sessions = sessionRepo.findAllById(request.getSessionIds());

        BigDecimal total = sessions.stream()
                .map(this::calculateFee)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Payment payment = new Payment();
        payment.setAmount(total);
        payment.setStatus(PaymentStatus.PENDING);
        payment.setSessions(sessions);

        Payment saved = paymentRepo.save(payment);

        return new PaymentResponse(
                saved.getId(),
                saved.getAmount(),
                saved.getStatus().name(),
                sessions.stream().map(ParkingSession::getId).toList()
        );
    }

    public PaymentPayResponse pay(Long id) {

        Payment payment = paymentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        if (payment.getStatus() == PaymentStatus.PAID) {
            throw new RuntimeException("Payment already completed");
        }

        payment.setStatus(PaymentStatus.PAID);
        payment.setCreatedAt(LocalDateTime.now());

        Payment saved = paymentRepo.save(payment);

        return new PaymentPayResponse(
                saved.getId(),
                saved.getAmount(),
                saved.getStatus().name(),
                "Payment success"
        );
    }

    public BigDecimal calculateFee(ParkingSession session) {

        LocalDateTime entry = session.getEntryTime();

        LocalDateTime exit = session.getExitTime() != null
                ? session.getExitTime()
                : LocalDateTime.now();

        long hours = Duration.between(entry, exit).toHours();

        if (hours == 0) hours = 1;

        BigDecimal rate = new BigDecimal("5000"); // ví dụ

        return rate.multiply(BigDecimal.valueOf(hours));
    }
}
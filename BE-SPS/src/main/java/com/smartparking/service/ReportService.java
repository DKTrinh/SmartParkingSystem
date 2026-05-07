package com.smartparking.service;
import com.smartparking.repository.*;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Autowired private PaymentRepository paymentRepo;

    public BigDecimal getRevenue() {
        return paymentRepo.sumAllPaid();
    }

    public Long getUsage() {
        return paymentRepo.count();
    }
}
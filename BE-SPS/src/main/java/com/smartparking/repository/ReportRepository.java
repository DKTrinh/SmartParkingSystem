package com.smartparking.repository;

import java.math.BigDecimal;

public interface ReportRepository {

    BigDecimal getRevenue();

    Long getTotalSessions();
}

package com.smartparking.repository;

import com.smartparking.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
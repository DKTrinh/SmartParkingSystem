package com.smartparking.service;

import com.smartparking.entity.*;
import com.smartparking.dto.*;
import com.smartparking.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class TicketService {

    @Autowired
    private TicketRepository repo;

    public boolean validate(TicketRequest req) {

        Ticket ticket = repo.findById(req.getTicketId())
                .orElseThrow();

        return ticket.getEnd_date().isAfter(LocalDateTime.now());
    }
}
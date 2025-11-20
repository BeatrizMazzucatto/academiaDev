package com.academiadev.repository;

import java.util.List;
import java.util.Optional;
import com.academiadev.model.SupportTicket;

public interface SupportTicketRepository {

    void save(SupportTicket supportTicket);
    Optional<SupportTicket> processNext();
    List<SupportTicket> findAll();
    
}


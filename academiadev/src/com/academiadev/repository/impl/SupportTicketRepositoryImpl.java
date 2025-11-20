package com.academiadev.repository.impl;

import com.academiadev.model.SupportTicket;
import com.academiadev.repository.DataStore;
import com.academiadev.repository.SupportTicketRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SupportTicketRepositoryImpl implements SupportTicketRepository {

    @Override
    public void save(SupportTicket supportTicket) {
        DataStore.SUPPORT_TICKETS.add(supportTicket);
    }

    @Override
    public Optional<SupportTicket> processNext() {
        return Optional.ofNullable(DataStore.SUPPORT_TICKETS.poll());
    }

    @Override
    public List<SupportTicket> findAll() {
        return new ArrayList<>(DataStore.SUPPORT_TICKETS);
    }
}


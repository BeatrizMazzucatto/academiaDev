package com.academiadev.service;

import com.academiadev.repository.SupportTicketRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.academiadev.exceptions.AccessDeniedException;
import com.academiadev.dto.SupportTicketDTO;
import com.academiadev.dto.TicketExportDTO;
import com.academiadev.model.Admin;
import com.academiadev.model.BasicPlan;
import com.academiadev.model.Student;
import com.academiadev.model.SupportTicket;
import com.academiadev.model.User;

public class SupportTicketService {

    private final SupportTicketRepository str;

    public SupportTicketService(SupportTicketRepository str) {
        this.str = str;
    }

    public SupportTicketDTO addTicket(User author, String title, String description) {
        SupportTicket newTicket = new SupportTicket(author.getEmail(), title, description);
        this.str.save(newTicket);
        return toDto(newTicket, author);
    }

    public Optional<SupportTicketDTO> attendNextTicket(User user) {
        if (!(user != null && Admin.class.isAssignableFrom(user.getClass()))) {
            throw new AccessDeniedException("Apenas administradores podem atender tickets.");
        }
        Optional<SupportTicket> ticketOpt = str.processNext();
        if (ticketOpt.isEmpty()) {
            return Optional.empty();
        }
        SupportTicket ticket = ticketOpt.get();
        // Cria um Student temporário apenas para o DTO
        User author = new Student("Usuário", ticket.getEmail(), new BasicPlan());
        return Optional.of(toDto(ticket, author));
    }

    public List<SupportTicketDTO> findAll() {
        return str.findAll().stream()
                .map(ticket -> {
                    // Cria um Student temporário apenas para o DTO
                    User author = new Student("Usuário", ticket.getEmail(), new com.academiadev.model.BasicPlan());
                    return toDto(ticket, author);
                })
                .toList();
    }

    public Collection<TicketExportDTO> getAllTicketsForExport() {
        return str.findAll().stream()
                .map(this::toExportDTO)
                .collect(Collectors.toList());
    }

    private SupportTicketDTO toDto(SupportTicket ticket, User user) {
        SupportTicketDTO dto = new SupportTicketDTO();

        dto.setTitle(ticket.getTitle());
        dto.setDescription(ticket.getMessage());
        dto.setEmailAuthor(user.getEmail());

        return dto;
    }

    private TicketExportDTO toExportDTO(SupportTicket st) {
        TicketExportDTO dto = new TicketExportDTO();
        dto.setUser(st.getEmail()); // Using email as user name for now
        dto.setEmail(st.getEmail());
        dto.setTitle(st.getTitle());
        dto.setDescription(st.getMessage());
        return dto;
    
    }

}


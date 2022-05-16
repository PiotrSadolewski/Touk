package com.example.touk.Service;

import com.example.touk.model.Ticket;

import java.util.List;

public interface TicketService {
    Ticket saveTicket(Ticket ticket);
    List<Ticket> getAllTickets();
    Ticket getTicketById(Long id);
    Ticket updateTicket(Ticket ticket, Long id);
    void deleteTicket(Long id);
}

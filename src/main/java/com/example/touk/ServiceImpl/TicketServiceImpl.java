package com.example.touk.ServiceImpl;

import com.example.touk.Service.TicketService;;
import com.example.touk.model.Ticket;
import com.example.touk.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("could not find Ticket with id: " + id));
    }

    @Override
    public Ticket updateTicket(Ticket ticket, Long id) {
        Ticket existingTicket = ticketRepository.findById(id).orElseThrow();
        existingTicket.setTicketType(ticket.getTicketType());
        existingTicket.setBuyDate(ticket.getBuyDate());
        ticketRepository.save(existingTicket);
        return existingTicket;
    }

    @Override
    public void deleteTicket(Long id) {
        Ticket deleteTicket = ticketRepository.findById(id).orElseThrow();
        ticketRepository.delete(deleteTicket);
    }
}

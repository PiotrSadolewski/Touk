package com.example.touk.controller;

import com.example.touk.Service.TicketService;
import com.example.touk.model.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<Ticket> saveTicket(@RequestBody Ticket ticket){
        return new ResponseEntity<Ticket>(ticketService.saveTicket(ticket), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }

    @GetMapping("{id}")
    public ResponseEntity<Ticket> getTicketBy(@PathVariable("id") long ticketId){
        return new ResponseEntity<Ticket>(ticketService.getTicketById(ticketId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable("id") long id, @RequestBody Ticket ticket){
        return new ResponseEntity<Ticket>(ticketService.updateTicket(ticket, id), HttpStatus.OK);
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity<String> deleteTicket(@PathVariable("id") long id){
        ticketService.deleteTicket(id);
        return new ResponseEntity<String>("Ticket :"+ id + " deleted succesfully!", HttpStatus.OK);
    }
}

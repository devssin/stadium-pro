// TicketController.java
package com.example.stadium_pro.controller;

import com.example.stadium_pro.model.dto.TicketDTO;
import com.example.stadium_pro.model.dto.responseDto.TicketRespDTO;
import com.example.stadium_pro.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public ResponseEntity<List<TicketRespDTO>> getAllTickets() {
        List<TicketRespDTO> tickets = ticketService.getAllTickets();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDTO> getTicketById(@PathVariable("id") Long ticketId) {
        TicketDTO ticketDTO = ticketService.getTicketById(ticketId);
        return new ResponseEntity<>(ticketDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TicketDTO> createTicket(@Valid @RequestBody TicketDTO ticketDTO) {
        TicketDTO createdTicketDTO = ticketService.createTicket(ticketDTO);
        return new ResponseEntity<>(createdTicketDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketDTO> updateTicket(@PathVariable("id") Long ticketId, @Valid @RequestBody TicketDTO ticketDTO) {
        TicketDTO updatedTicketDTO = ticketService.updateTicket(ticketId, ticketDTO);
        return new ResponseEntity<>(updatedTicketDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable("id") Long ticketId) {
        ticketService.deleteTicket(ticketId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

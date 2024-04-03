package com.example.stadium_pro.repository;

import com.example.stadium_pro.model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}

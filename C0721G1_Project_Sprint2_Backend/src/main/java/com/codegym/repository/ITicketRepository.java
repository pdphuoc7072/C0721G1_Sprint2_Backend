package com.codegym.repository;

import com.codegym.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITicketRepository extends JpaRepository<Ticket, Long> {
}

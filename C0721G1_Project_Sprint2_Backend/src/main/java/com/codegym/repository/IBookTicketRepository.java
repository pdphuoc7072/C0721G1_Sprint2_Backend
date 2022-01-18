package com.codegym.repository;

import com.codegym.model.BookedTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookTicketRepository extends JpaRepository<BookedTicket, Long> {
}

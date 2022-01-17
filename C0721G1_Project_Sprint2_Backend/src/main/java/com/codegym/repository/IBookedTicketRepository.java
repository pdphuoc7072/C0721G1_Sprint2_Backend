package com.codegym.repository;

import com.codegym.model.BookedTicket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBookedTicketRepository extends JpaRepository<BookedTicket, Long> {
    @Query(value = "SELECT * FROM booked_ticket WHERE ticket_code IN (SELECT `code` FROM ticket WHERE user_id = :id)", nativeQuery = true)
    Page<BookedTicket> findTicketsUser(@Param("id") long id, Pageable pageable);
}

package com.codegym.service;

import com.codegym.model.BookedTicket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IBookedTicketService {
    Page<BookedTicket> findTicketsUser(String id, Pageable pageable);

}

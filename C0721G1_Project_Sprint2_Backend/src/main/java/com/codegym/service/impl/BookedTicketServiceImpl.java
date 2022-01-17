package com.codegym.service.impl;

import com.codegym.model.BookedTicket;
import com.codegym.repository.IBookedTicketRepository;
import com.codegym.service.IBookedTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookedTicketServiceImpl implements IBookedTicketService {
    @Autowired
    IBookedTicketRepository bookedTicketRepository;
    @Override
    public Page<BookedTicket> findTicketsUser(long id, Pageable pageable) {
        return bookedTicketRepository.findTicketsUser(id, pageable);
    }
}

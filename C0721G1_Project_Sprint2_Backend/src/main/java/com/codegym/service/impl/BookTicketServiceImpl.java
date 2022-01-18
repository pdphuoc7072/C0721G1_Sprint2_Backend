package com.codegym.service.impl;

import com.codegym.model.BookedTicket;
import com.codegym.repository.IBookTicketRepository;
import com.codegym.repository.ITicketRepository;
import com.codegym.service.IBookTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookTicketServiceImpl implements IBookTicketService {

    @Autowired
    private IBookTicketRepository iBookTicketRepository;

    @Override
    public List<BookedTicket> findAll() {
        return iBookTicketRepository.findAll();
    }

    @Override
    public Optional<BookedTicket> findById(Long id) {
        return iBookTicketRepository.findById(id);
    }

    @Override
    public void save(BookedTicket bookedTicket) {
        iBookTicketRepository.save(bookedTicket);
    }

    @Override
    public void remove(Long id) {
        iBookTicketRepository.deleteById(id);
    }
}

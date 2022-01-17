package com.codegym.service.impl;

import com.codegym.model.Ticket;
import com.codegym.repository.ITicketRepository;
import com.codegym.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements ITicketService {
    @Autowired
    private ITicketRepository iTicketRepository;

    @Override
    public List<Ticket> findAll() {
        return iTicketRepository.findAll();
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        return iTicketRepository.findById(id);
    }

    @Override
    public void save(Ticket ticket) {
        iTicketRepository.save(ticket);
    }

    @Override
    public void remove(Long id) {
        iTicketRepository.deleteById(id);
    }
}

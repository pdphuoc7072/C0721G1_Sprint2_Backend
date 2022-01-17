package com.codegym.service.impl;

import com.codegym.model.Seat;
import com.codegym.repository.ISeatRepository;
import com.codegym.service.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatServiceImpl implements ISeatService {
    @Autowired
    private ISeatRepository iSeatRepository;

    @Override
    public List<Seat> findAll() {
        return iSeatRepository.findAll();
    }

    @Override
    public Optional<Seat> findById(Long id) {
        return iSeatRepository.findById(id);
    }

    @Override
    public void save(Seat seat) {
        iSeatRepository.save(seat);
    }

    @Override
    public void remove(Long id) {
        iSeatRepository.deleteById(id);
    }
}

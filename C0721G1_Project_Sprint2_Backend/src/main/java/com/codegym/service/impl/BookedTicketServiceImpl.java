package com.codegym.service.impl;

import com.codegym.dto.IMovieDTO;
import com.codegym.dto.IUserDTO;
import com.codegym.model.BookedTicket;
import com.codegym.repository.IBookedTicketRepository;
import com.codegym.service.IBookedTickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

;


@Service
public class BookedTicketServiceImpl implements IBookedTickService {
@Autowired
private IBookedTicketRepository iBookedTicketRepository;
    @Override
    public List<IMovieDTO> getMovieStatsList(LocalDate startDate, LocalDate endDate) {
        return iBookedTicketRepository.getMovieStatsTop(startDate,endDate);
    }

    @Override
    public List<IUserDTO> getUserStatsList(LocalDate startDate, LocalDate endDate) {
        return iBookedTicketRepository.getUserStatsTop(startDate,endDate);
    }

    @Override
    public List<BookedTicket> findAll() {
        return null;
    }

    @Override
    public Optional<BookedTicket> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(BookedTicket bookedTicket) {
    }
    @Override
    public void remove(Long id) {

    }
}

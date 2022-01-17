package com.codegym.service;

import com.codegym.dto.IMovieDTO;
import com.codegym.dto.IUserDTO;
import com.codegym.model.BookedTicket;

import java.time.LocalDate;
import java.util.List;

public interface IBookedTickService extends IGeneralService<BookedTicket> {
    List<IMovieDTO> getMovieStatsList(LocalDate startDate, LocalDate endDate);
    List<IUserDTO> getUserStatsList(LocalDate startDate, LocalDate endDate);
}

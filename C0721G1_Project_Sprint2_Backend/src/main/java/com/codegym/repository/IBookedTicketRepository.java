package com.codegym.repository;

import com.codegym.dto.IMovieDTO;
import com.codegym.dto.IUserDTO;
import com.codegym.model.BookedTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IBookedTicketRepository extends JpaRepository<BookedTicket,Long> {

    @Query(nativeQuery = true, value = "select name_movie,sum(total_money) as money ,count(ticket_code) as ticket from booked_ticket\n" +
            "where day_booked between :startDate and :endDate\n" +
            "group by booked_ticket.name_movie\n" +
            "order by  money desc\n" +
            "limit 0,99;")
    List<IMovieDTO> getMovieStatsTop(@Param("startDate") LocalDate date, @Param("endDate") LocalDate date2);

    @Query(nativeQuery = true,value="select code_user,name_user,sum(total_money) as money ,count(ticket_code) as ticket,(count(ticket_code)*sum(total_money)/1000) as `point` from booked_ticket\n" +
            "where day_booked between :startDate and :endDate\n" +
            "group by booked_ticket.name_movie\n" +
            "order by  money desc\n" +
            "limit 0,99;")
    List<IUserDTO> getUserStatsTop(@Param("startDate") LocalDate date, @Param("endDate") LocalDate date2);
}


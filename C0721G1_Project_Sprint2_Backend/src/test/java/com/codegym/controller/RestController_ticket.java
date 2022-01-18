package com.codegym.controller;


import com.codegym.dto.SeatDto;
import com.codegym.dto.TicketDto;
import com.codegym.dto.UserDto;
import com.codegym.model.Movie;
import com.codegym.model.Schedule;
import com.codegym.model.Seat;
import com.codegym.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RestController_ticket {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void Find_movie_byid() throws Exception {
       long id = 1;
       TicketDto ticketDto = new TicketDto();
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/movie/1")
                .content(this.objectMapper.writeValueAsBytes(ticketDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void Find_movie_byid_2() throws Exception {
        TicketDto ticketDto = new TicketDto();
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/movie/99")
                .content(this.objectMapper.writeValueAsBytes(ticketDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void create_ticket_1() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setId((long) 1);
        ticketDto.setCode(null);
        SeatDto seatDto = new SeatDto();
        seatDto.setName("b1");
        ticketDto.setSeats((List<Seat>) seatDto);
        ticketDto.setStatus(0);
        User userDto= new User();
        userDto.setName("nguyễn van a");
        userDto.setEmail("nguyenduc251196@gmail.com");
        ticketDto.setUser(userDto);
        Schedule schedule = new Schedule();
        Movie movie = new Movie();
        schedule.setMovie(movie);
        ticketDto.setSchedule(schedule);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/user/paypal")
                .content(this.objectMapper.writeValueAsString(ticketDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void create_ticket_2() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setId((long) 1);
        ticketDto.setCode(null);
        SeatDto seatDto = new SeatDto();
        seatDto.setName("b1");
        ticketDto.setSeats((List<Seat>) seatDto);
        ticketDto.setStatus(0);
        User userDto= new User();
        userDto.setName("nguyễn van a");
        userDto.setEmail("nguyenduc251196@gmail.com");
        ticketDto.setUser(userDto);
        Schedule schedule = new Schedule();
        ticketDto.setSchedule(schedule);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/user/paypal")
                .content(this.objectMapper.writeValueAsString(ticketDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void create_ticket_3() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setId((long) 1);
        ticketDto.setCode(null);
        SeatDto seatDto = new SeatDto();
        ticketDto.setSeats((List<Seat>) seatDto);
        ticketDto.setStatus(0);
        User userDto= new User();
        userDto.setName("nguyễn van a");
        userDto.setEmail("nguyenduc251196@gmail.com");
        ticketDto.setUser(userDto);
        Schedule schedule = new Schedule();
        ticketDto.setSchedule(schedule);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/user/paypal")
                .content(this.objectMapper.writeValueAsString(ticketDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }@Test
    public void create_ticket_4() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setId((long) 1);
        ticketDto.setCode(null);
        SeatDto seatDto = new SeatDto();
        ticketDto.setSeats((List<Seat>) seatDto);
        ticketDto.setStatus(null);
        User userDto= new User();
        userDto.setName("nguyễn van a");
        userDto.setEmail("nguyenduc251196@gmail.com");
        ticketDto.setUser(userDto);
        Schedule schedule = new Schedule();
        ticketDto.setSchedule(schedule);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/user/paypal")
                .content(this.objectMapper.writeValueAsString(ticketDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}

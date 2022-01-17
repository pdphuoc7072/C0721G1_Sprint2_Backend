package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = DayShow.class)
    @JoinColumn(name = "day_show_id", referencedColumnName = "id")
    private DayShow dayShow;

    @ManyToOne(targetEntity = HourShow.class)
    @JoinColumn(name = "hour_show_id", referencedColumnName = "id")
    private HourShow hourShow;

    @ManyToOne(targetEntity = Movie.class)
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;

    @JsonBackReference(value = "schedule_ticket_back_class")
    @OneToMany(mappedBy = "schedule")
    private List<Ticket> tickets;

    public Schedule() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DayShow getDayShow() {
        return dayShow;
    }

    public void setDayShow(DayShow dayShow) {
        this.dayShow = dayShow;
    }

    public HourShow getHourShow() {
        return hourShow;
    }

    public void setHourShow(HourShow hourShow) {
        this.hourShow = hourShow;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}

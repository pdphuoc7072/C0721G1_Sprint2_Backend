package com.codegym.model;

import javax.persistence.*;

@Entity
public class BookedTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ticketCode;

    private String dayBooked;

    private String dayShow;

    private String hourShow;

    private String seatBooked;

    private Integer totalMoney;

    public BookedTicket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(Long ticketCode) {
        this.ticketCode = ticketCode;
    }

    public String getDayBooked() {
        return dayBooked;
    }

    public void setDayBooked(String dayBooked) {
        this.dayBooked = dayBooked;
    }

    public String getDayShow() {
        return dayShow;
    }

    public void setDayShow(String dayShow) {
        this.dayShow = dayShow;
    }

    public String getHourShow() {
        return hourShow;
    }

    public void setHourShow(String hourShow) {
        this.hourShow = hourShow;
    }

    public String getSeatBooked() {
        return seatBooked;
    }

    public void setSeatBooked(String seatBooked) {
        this.seatBooked = seatBooked;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }
}

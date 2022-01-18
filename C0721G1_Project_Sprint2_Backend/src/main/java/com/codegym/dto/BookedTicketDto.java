package com.codegym.dto;


public class BookedTicketDto {

    private Long id;

    private String ticketCode;

    private String codeUser;
    private String nameUser;

    private String dayBooked;

    private String dayShow;

    private String hourShow;

    private String seatBooked;

    private Integer totalMoney;
    public BookedTicketDto() {
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getCodeUser() {
        return codeUser;
    }

    public void setCodeUser(String codeUser) {
        this.codeUser = codeUser;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
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

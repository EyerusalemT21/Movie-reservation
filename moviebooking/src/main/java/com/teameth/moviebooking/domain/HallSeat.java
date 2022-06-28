package com.teameth.moviebooking.domain;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Table(name = "hallseat")
public class HallSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int seatId;
    private String seatType;
    private int seatNumber;
    @ManyToOne
    @JoinColumn(name = "hall_Id")
    private CinemaHall cinemaHall;

    public HallSeat() {
    }

    public HallSeat(int seatId, String seatType, int seatNumber, CinemaHall cinemaHall) {
        this.seatId = seatId;
        this.seatType = seatType;
        this.seatNumber = seatNumber;
        this.cinemaHall = cinemaHall;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }
}

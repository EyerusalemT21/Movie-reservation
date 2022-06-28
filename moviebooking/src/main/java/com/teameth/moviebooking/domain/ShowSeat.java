package com.teameth.moviebooking.domain;


import javax.persistence.*;

@Entity
public class ShowSeat {
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO)
    private int seatId;
    private double price;
    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "fkhallSeatId" )
    private HallSeat hallSeat;
    private String status;

    @ManyToOne
    @JoinColumn(name="fkcinemaId")
    private MovieSchedule movieSchedule;

    @ManyToOne
    @JoinColumn(name = "reservationId")
    private Reservation reservation;

    public ShowSeat() {
    }



    public ShowSeat(int seatId, double price, HallSeat hallSeat, String status, MovieSchedule movieSchedule, Reservation reservation) {
        this.seatId = seatId;
        this.price = price;
        this.hallSeat = hallSeat;
        this.status = status;
        this.movieSchedule = movieSchedule;
        this.reservation = reservation;
    }

    public int getSeat_id() {
        return seatId;
    }

    public void setSeat_id(int seatId) {
        this.seatId = seatId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public HallSeat getHallSeat() {
        return hallSeat;
    }

    public void setHallSeat(HallSeat hallSeat) {
        this.hallSeat = hallSeat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MovieSchedule getMovieSchedule() {
        return movieSchedule;
    }

    public void setMovieSchedule(MovieSchedule movieSchedule) {
        this.movieSchedule = movieSchedule;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}



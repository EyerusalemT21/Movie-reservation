package com.teameth.moviebooking.domain;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private int reservationId;
    private int numberOfSeats;
    private Time timeStamp;
    private Date dateStamp;
    private String status;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "fkmovieScheduleId" )
    private MovieSchedule movieSchedule;


    public Reservation() {
    }

    public Reservation(int reservationId, int numberOfSeats, Time timeStamp, java.lang.String status) {
        this.reservationId = reservationId;
        this.numberOfSeats = numberOfSeats;
        this.timeStamp = timeStamp;
        this.status = status;
    }

    public Reservation(int reservationId, int numberOfSeats, Time timeStamp, String String, User user, MovieSchedule movieSchedule) {
        this.reservationId = reservationId;
        this.numberOfSeats = numberOfSeats;
        this.timeStamp = timeStamp;
        this.status = String;
        this.user = user;
        this.movieSchedule = movieSchedule;
    }

    public Date getDateStamp() {
        return dateStamp;
    }

    public void setDateStamp(Date dateStamp) {
        this.dateStamp = dateStamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getReservation_id() {
        return reservationId;
    }

    public void setReservation_id(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Time getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Time timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getString() {
        return status;
    }

    public void setString(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MovieSchedule getMovieSchedule() {
        return movieSchedule;
    }

    public void setMovieSchedule(MovieSchedule movieSchedule) {
        this.movieSchedule = movieSchedule;
    }

}


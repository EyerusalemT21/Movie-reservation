package com.teameth.moviebooking.models;

import com.teameth.moviebooking.domain.MovieSchedule;
import com.teameth.moviebooking.domain.Status;
import com.teameth.moviebooking.domain.User;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ReservationRequest {

    private String reservation_id;
    public String numberOfSeats;
    public  String timeStamp;

    public String seatIds;

    //public String userId;

    public ReservationRequest() {
    }

    public ReservationRequest(String reservation_id, String numberOfSeats, String timeStamp, String status, String user, String movieSchedule) {
        this.reservation_id = reservation_id;
        this.numberOfSeats = numberOfSeats;
        this.timeStamp = timeStamp;
        this.status = status;
        this.user = user;
        this.movieSchedule = movieSchedule;
    }

    private String status;

    public Integer getReservation_id() {
        return 5;
    }

    public void setReservation_id(String reservation_id) {
        this.reservation_id = reservation_id;
    }

    public Integer getNumberOfSeats() {
        Integer id=  Integer.valueOf(numberOfSeats);
        return id;
    }



    public void setNumberOfSeats(String numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Time getTimeStamp() throws ParseException {
        LocalTime now= LocalTime.now();
        /*SimpleDateFormat sdf = new SimpleDateFormat("h:mm:ss");
        long ms = sdf.parse(timeStamp).getTime();
        Time t = new Time(ms);*/

        return Time.valueOf(now);
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMovieSchedule() {
        return movieSchedule;
    }

    public String[] getSeatIds() {
        return this.seatIds.split(",");
    }

    public void setMovieSchedule(String movieSchedule) {
        this.movieSchedule = movieSchedule;
    }

    private String user;
    private String movieSchedule;





}

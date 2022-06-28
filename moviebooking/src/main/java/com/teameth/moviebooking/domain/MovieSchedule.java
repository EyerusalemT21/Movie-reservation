package com.teameth.moviebooking.domain;

import com.teameth.moviebooking.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movieschedule")
public class MovieSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int  movieScheduleId;
    private Time start_time;
    private Time end_time;
    private Date date;

    public MovieSchedule() {
    }

    public CinemaHall getCinemaHallList() {
        return cinemaHallList;
    }

    public void setCinemaHallList(CinemaHall cinemaHallList) {
        this.cinemaHallList = cinemaHallList;
    }

    // private int movieId;
    @ManyToOne(optional=false)
    @JoinColumn(name="fkmovieId",referencedColumnName="movieId")
    private  Movie movie;

//    @ManyToMany
//    @JoinTable(name = "scheduled_hall", joinColumns = @JoinColumn(name="movieScheduleId"),
//            inverseJoinColumns = @JoinColumn(name="hall_id"))
//    private List<CinemaHall> cinemaHallList = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "fkhallId", referencedColumnName = "hallId")
    private CinemaHall cinemaHallList;


    public MovieSchedule(int movieScheduleId, Time start_time, Time end_time, Date date) {
        this.movieScheduleId = movieScheduleId;
        this.start_time = start_time;
        this.end_time = end_time;
        this.date = date;
        this.movie = new Movie();
    }

    public int getMovie_schedule_id() {
        return movieScheduleId;
    }

    public void setMovie_schedule_id(int movieScheduleId) {
        this.movieScheduleId = movieScheduleId;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

    public Date getDate() {
        return date;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}

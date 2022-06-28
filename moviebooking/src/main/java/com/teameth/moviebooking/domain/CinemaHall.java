package com.teameth.moviebooking.domain;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cinemahall")
public class CinemaHall {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO)
    private int hallId;

    private String hallName;
    private int total_num_of_seat;
    @ManyToOne
    @JoinColumn(name="cinemaId")//,referencedColumnName="cinema_id")
    private Cinema cinema;

    @OneToMany(mappedBy = "cinemaHallList")
    private List<MovieSchedule> movieScheduleList = new ArrayList<>();

    public CinemaHall() {
    }

    public int getHall_id() {
        return hallId;
    }

    public void setHall_id(int hallId) {
        this.hallId = hallId;
    }

    public String getHall_name() {
        return hallName;
    }

    public void setHall_name(String hallName) {
        this.hallName = hallName;
    }

    public int getTotal_num_of_seat() {
        return total_num_of_seat;
    }

    public void setTotal_num_of_seat(int total_num_of_seat) {
        this.total_num_of_seat = total_num_of_seat;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
}

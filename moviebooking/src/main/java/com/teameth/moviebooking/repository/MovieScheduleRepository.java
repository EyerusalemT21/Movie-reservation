package com.teameth.moviebooking.repository;

import com.teameth.moviebooking.domain.Cinema;
import com.teameth.moviebooking.domain.CinemaHall;
import com.teameth.moviebooking.domain.Movie;
import com.teameth.moviebooking.domain.MovieSchedule;
import com.teameth.moviebooking.service.CinemaHallService;
import com.teameth.moviebooking.service.MovieScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

public interface MovieScheduleRepository extends JpaRepository<MovieSchedule,Integer> {
    public MovieSchedule findByDate(Date date);

    /*public default List<MovieSchedule> findByCinemaHallListHallId(Integer id){
        List<MovieSchedule> schedules= findAll();
        return schedules.stream().filter(schedule -> schedule.getCinemaHallList().getHall_id() == id).collect(Collectors.toList());
    };*/

    public List<MovieSchedule> findByCinemaHallListHallId(Integer id);


    public Movie findByMovieMovieid(Integer id);
}

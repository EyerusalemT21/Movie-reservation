package com.teameth.moviebooking.controller;


import com.teameth.moviebooking.domain.*;
import com.teameth.moviebooking.models.MovieRequest;
import com.teameth.moviebooking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieScheduleController {
    @Autowired
    private MovieScheduleService movieScheduleService;

    @Autowired
    private CinemaHallService cinemaHallService;
    @Autowired
    private MovieService movieService;

    @Autowired
    private HallSeatService hallSeatService;

    @Autowired
    private ShowSeatService showSeatService;

    @RequestMapping("/movieSchedule")
    public List<MovieSchedule> getAllMovieSchedules(){
        return movieScheduleService.getAllMovieSchedule();
    }

   @RequestMapping("/movieSchedule/{moviescheduleId}")
    public MovieSchedule getmovieById(@PathVariable Integer movieScheduleId){
        return movieScheduleService.getMovieSchedule(movieScheduleId);
    }
    @RequestMapping("/movieSchedule/{scheduleDate}")
    public MovieSchedule getMovieByName(Date scheduleDate){
        return movieScheduleService.getMovieSchedulebyDate(scheduleDate);
    }

   /* @RequestMapping(method = RequestMethod.POST ,value="/movie/{movieId}/movieSchedule")
    public void saveNewMovieSchedule(@RequestBody MovieSchedule movieSchedule,@PathVariable Integer movieId){
        Movie movie = movieService.getMovie(movieId);
        movieSchedule.setMovie(movie);
        movieScheduleService.saveMovieSchedule(movieSchedule);
    }*/
   @RequestMapping(method = RequestMethod.POST ,value="/movie/{movieId}/movieSchedule")
   public void saveNewMovieSchedule(@RequestBody MovieRequest movieRequest, @PathVariable Integer movieId) throws ParseException {

       System.out.println(movieRequest.hallIds);

       Movie movie = movieService.getMovie(movieId);
       MovieSchedule movieSchedule = new MovieSchedule(0,
               movieRequest.getStart_time(),
               movieRequest.getEnd_time(),
               movieRequest.getDate());

       movieSchedule.setCinemaHallList(cinemaHallService.getCinemaHall(Integer.valueOf(movieRequest.getHallId())));
       movieSchedule.setMovie(movie);
       movieScheduleService.saveMovieSchedule(movieSchedule);

   }
    @RequestMapping("/movies/{movieId}")
    public List<MovieSchedule> getScheduleByMovieId(@PathVariable Integer movieId){
        //movieScheduleService.getScheduleByMovieId(movieId);
        List<MovieSchedule> movieScheduleList = movieScheduleService.getAllMovieSchedule();
        List<MovieSchedule> tobeReturned= new ArrayList<>();
        for(MovieSchedule ms :movieScheduleList){
            System.out.println(ms.getStart_time());
            System.out.println("curr"+Time.valueOf(LocalTime.now()));
            System.out.println(ms.getDate());
            System.out.println("curr"+Date.valueOf(LocalDate.now()));

            if(ms.getMovie().getmovieid() == movieId &&
                    ( (ms.getDate().after(Date.valueOf(LocalDate.now()))) ||
                    (   ms.getDate().toLocalDate().equals(LocalDate.now())
                    &&  ms.getStart_time().toLocalTime().compareTo(LocalTime.now()) > 0
                     )
                    ))
                tobeReturned.add(ms);
        }
        return tobeReturned;
    }
    @RequestMapping("/schedule/{scheduleId}")
    public List<Integer> getHallSeats(@PathVariable Integer scheduleId){
       List<Integer> listOfSeats = new ArrayList<>();
      MovieSchedule movieSchedule = movieScheduleService.getMovieSchedule(scheduleId);
       CinemaHall cinemaHall = movieSchedule.getCinemaHallList();
       List<HallSeat> hallSeats = hallSeatService.getHallSeatsByHallid(cinemaHall.getHall_id());
        for(HallSeat hs:hallSeats){
            listOfSeats.add(hs.getSeatId());
        }
       return listOfSeats;
    }

    @RequestMapping("/schedule/{scheduleId}/getShowseats")
    public List<Integer> getShowSeats(@PathVariable Integer scheduleId){
        List<Integer> listOfSeats = new ArrayList<>();
       // MovieSchedule movieSchedule = movieScheduleService.getMovieSchedule(scheduleId);
        List<ShowSeat> showseats = showSeatService.getListOFShowSeatsByScheduleID(scheduleId);

        for(ShowSeat ss:showseats){
            listOfSeats.add(ss.getHallSeat().getSeatId());
        }
        return listOfSeats;
    }




}

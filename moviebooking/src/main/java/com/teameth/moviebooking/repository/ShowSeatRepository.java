package com.teameth.moviebooking.repository;

import com.teameth.moviebooking.domain.ShowSeat;
import com.teameth.moviebooking.service.ShowSeatService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat,Integer> {

    List<ShowSeat> findByMovieScheduleMovieScheduleId(Integer scheduleId);
}

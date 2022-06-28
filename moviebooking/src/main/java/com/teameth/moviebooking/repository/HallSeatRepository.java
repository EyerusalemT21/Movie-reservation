package com.teameth.moviebooking.repository;

import com.teameth.moviebooking.domain.HallSeat;
import com.teameth.moviebooking.domain.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HallSeatRepository extends JpaRepository<HallSeat,Integer> {
    List<HallSeat> findByCinemaHallHallId(Integer id);
}

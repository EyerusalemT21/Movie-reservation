package com.teameth.moviebooking.service;

import com.teameth.moviebooking.domain.Reservation;
import com.teameth.moviebooking.domain.Role;
import com.teameth.moviebooking.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;


    public Reservation save(Reservation reservation) {
       return reservationRepository.save(reservation);
    }

    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();

    }
}

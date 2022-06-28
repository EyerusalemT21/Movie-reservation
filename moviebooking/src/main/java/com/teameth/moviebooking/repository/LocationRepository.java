package com.teameth.moviebooking.repository;

import com.teameth.moviebooking.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Integer> {
    //Optional<Location> findById(Integer id);
}

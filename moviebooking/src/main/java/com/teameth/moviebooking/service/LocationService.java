package com.teameth.moviebooking.service;

import com.teameth.moviebooking.domain.Location;
import com.teameth.moviebooking.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAllLocation(){
        List<Location> locations= new ArrayList<>();
        return locationRepository.findAll();
    }

    public void saveLocation(Location location){
            locationRepository.save(location);
    }

    public Location getSpecificLocation(int locationId){
        return locationRepository.findById(locationId).get();
    }
}

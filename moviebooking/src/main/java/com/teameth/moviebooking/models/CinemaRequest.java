package com.teameth.moviebooking.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teameth.moviebooking.domain.Cinema;
import com.teameth.moviebooking.domain.CinemaHall;
import com.teameth.moviebooking.domain.Location;
import com.teameth.moviebooking.service.CinemaHallService;
import com.teameth.moviebooking.service.CinemaService;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CinemaRequest {

    private String cinema_id;
    private String cinema_name;


    private String number_of_halls;

    private String location;


    private String cinemaHall;



    public CinemaRequest() {
    }
    public CinemaRequest(String cinema_id, String cinema_name, String number_of_halls, String  location, String cinemaHallList) throws JsonProcessingException {
        this.cinema_id = cinema_id;
        this.cinema_name = cinema_name;
        this.number_of_halls = number_of_halls;
        this.location = location;
        this.cinemaHall = cinemaHallList;
    }

    /*public int getCinema_id() {
        return Integer.valueOf(cinema_id);
    }*/

    /*public void setCinema_id(int cinema_id) {
        this.cinema_id = cinema_id;
    }*/

    public String getCinema_name() {
        return cinema_name;
    }

    /*public void setCinema_name(String cinema_name) {
        this.cinema_name = cinema_name;
    }*/

       /* public List<CinemaHall> getCinemaHalls() throws JsonProcessingException {
            ObjectMapper mapper = new ObjectMapper();
            List<CinemaHall> cinemaHalls = mapper.readValue(cinemaHall, new TypeReference<List<CinemaHall>>() {
            });
    return cinemaHalls;
        }*/
    public String getNumber_of_halls() {
        return number_of_halls;
    }

    /*public void setNumber_of_halls(int number_of_halls) {
        this.number_of_halls = number_of_halls;
    }*/

    /*public Location getLocation() throws JsonProcessingException {
        JSONParser parser = new JSONParser(location);
        ObjectMapper mapper = new ObjectMapper();
        Location loc = mapper.readValue(location,Location.class);
        return loc;
    }*/


    /*public void setLocation(Location location) {
        this.location = location;
    }*/

    public String getCinemaHallList() {
       // System.out.println(cinemaHallList.size());
        return cinemaHall;
    }

    /*public void setCinemaHallList(List<CinemaHall> cinemaHallList) {

        this.cinemaHallList = cinemaHallList;
    }*/

    /*@Override
    public String toString() {
        return "CinemaRequest [cinema ", comments=" + comments + ", description=" + description
                + ", images=" + images + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";;
    }*/
}

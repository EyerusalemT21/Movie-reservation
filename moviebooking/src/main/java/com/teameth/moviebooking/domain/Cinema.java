package com.teameth.moviebooking.domain;

import jdk.jfr.DataAmount;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cinema")
public class Cinema {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private int cinemaId;

    private String cinema_name;

    //private int location_id;
    private int number_of_halls;

    @ManyToOne(optional=false)
    @JoinColumn(name="location_id",referencedColumnName="id")
    private Location location;
    //private List<Halls> halls;

   /* public List<CinemaHall> getCinemaHallList() {
        return cinemaHallList;
    }

    public void setCinemaHallList(List<CinemaHall> cinemaHallList) {
        this.cinemaHallList = cinemaHallList;
    }
*/
   // @OneToMany(mappedBy = "cinema")
    //@JoinColumn(name = "cinema_ID")  //referencedColumnName = "hall_id"
    //public List<CinemaHall> cinemaHallList;
    public Cinema() {
    }

    public Cinema(int cinemaId, String cinema_name, int location_id, int number_of_halls) {
        this.cinemaId = cinemaId;
        this.cinema_name = cinema_name;
        //this.location_id = location_id;
        this.number_of_halls = number_of_halls;
        this.location = new Location();

    }

    public int getCinema_id() {
        return cinemaId;
    }

    public void setCinema_id(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinema_name() {
        return cinema_name;
    }

    public void setCinema_name(String cinema_name) {
        this.cinema_name = cinema_name;
    }

    /*public List<CinemaHall> getCinemaHallList() {
        return cinemaHallList;
    }

    public void setCinemaHallList(List<CinemaHall> cinemaHallList) {
        this.cinemaHallList = cinemaHallList;
    }*/

   /* public int getlocation_id() {
        return location_id;
    }

    public void setlocation_id(int location_id) {
        this.location_id = location_id;
    }*/

    public int getNumber_of_halls() {
        return number_of_halls;
    }

    public void setNumber_of_halls(int number_of_halls) {
        this.number_of_halls = number_of_halls;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}

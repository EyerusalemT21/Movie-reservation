package com.teameth.moviebooking.models;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class MovieRequest {
    private  String movie_schedule_id;
    private String start_time;
    private String end_time;
    private String date;

    public String hallIds;

    public Integer getMovie_schedule_id() {

        Integer id=  Integer.getInteger(movie_schedule_id);
        return id;
    }

    public void setMovie_schedule_id(String movie_schedule_id) {
        this.movie_schedule_id = movie_schedule_id;
    }

    public Time getStart_time() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm:ss");
        long ms = sdf.parse(start_time).getTime();
        Time t = new Time(ms);
        return t;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public Time getEnd_time() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm:ss");
        long ms = sdf.parse(end_time).getTime();
        Time t = new Time(ms);
        return t;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public Date getDate() {
        Date dateR=Date.valueOf(date);//converting string into sql date
        System.out.println(date);
        return dateR;
    }

    public String getHallId() {
        return hallIds;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

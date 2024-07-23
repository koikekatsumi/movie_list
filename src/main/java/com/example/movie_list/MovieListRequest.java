package com.example.movie_list;

import java.util.Date;

public class MovieListRequest {
    private String name;
    private Date releaseDate;
    private String leadActor;
    private Integer boxOffice;

    public MovieListRequest(String name, Date releaseDate, String leadActor, int boxOffice) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.leadActor = leadActor;
        this.boxOffice = boxOffice;
    }

    public String getName() {
        return name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getLeadActor() {
        return leadActor;
    }

    public Integer getBoxOffice() {
        return boxOffice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setLeadActor(String leadActor) {
        this.leadActor = leadActor;
    }

    public void setBoxOffice(Integer boxOffice) {
        this.boxOffice = boxOffice;
    }
}


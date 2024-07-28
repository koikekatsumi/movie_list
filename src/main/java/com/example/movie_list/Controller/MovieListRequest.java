package com.example.movie_list.Controller;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MovieListRequest {
    private String name;
    private Date releaseDate;
    private String leadActor;
    private int boxOffice;
}

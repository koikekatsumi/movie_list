package com.example.movie_list;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MovieListService {
    private final MovieListMapper movieListMapper;

    public MovieListService(MovieListMapper movieListMapper) {

        this.movieListMapper = movieListMapper;
    }

    public MovieList findMovie(int id) {
        return movieListMapper.findById(id)
                .orElseThrow(() -> new MovieListNotFoundException("Movie with id " + id + " not found"));
    }

    public MovieList insert(String name, Date releaseDate, String leadActor, Integer boxOffice) {
        MovieList movieList = new MovieList(name, releaseDate, leadActor, boxOffice);
        movieListMapper.insert(movieList);
        return movieList;
    }
}


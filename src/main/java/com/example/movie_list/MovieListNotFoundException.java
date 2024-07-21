package com.example.movie_list;

public class MovieListNotFoundException extends RuntimeException {
    public MovieListNotFoundException(String message) {
        super(message);
    }
}


package com.example.movie_list.Controller;

public class MovieListResponse {
    private final String message;

    public MovieListResponse(String message) {

        this.message = message;
    }

    public String getMessage() {

        return message;
    }
}

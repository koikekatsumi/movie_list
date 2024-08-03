package com.example.movie_list;

public class MovieListDuplicatedException extends RuntimeException {
    public MovieListDuplicatedException(String message) {
        super(message);
    }
}

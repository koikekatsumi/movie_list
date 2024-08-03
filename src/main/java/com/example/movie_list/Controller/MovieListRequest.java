package com.example.movie_list.Controller;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MovieListRequest {

    @NotBlank
    private String name;

    @NotNull
    private Date releaseDate;

    @NotBlank
    private String leadActor;

    @NotNull
    @Min(value = 0)
    private int boxOffice;
}

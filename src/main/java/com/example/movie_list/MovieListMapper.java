package com.example.movie_list;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MovieListMapper {
    @Select("SELECT * FROM movies")
    List<MovieList> findAll();

    @Select("SELECT * FROM movies WHERE id =#{id}")
    Optional<MovieList> findById(int id);

    @Insert("INSERT INTO movies (name, releaseDate, leadActor, boxOffice) VALUES (#{name}, #{releaseDate}, #{leadActor},#{boxOffice})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(MovieList movieList);
}

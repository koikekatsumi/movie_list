package com.example.movie_list.dao;

import com.example.movie_list.entity.Movie;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MovieListMapper {
    @Select("SELECT * FROM movies")
    List<Movie> findAll();

    @Select("SELECT * FROM movies WHERE id =#{id}")
    Optional<Movie> findById(Integer id);

    @Select("SELECT * FROM movies WHERE name = #{name}")
    Optional<Movie> findByName(String name);

    @Insert("INSERT INTO movies (name, release_Date, lead_Actor, box_Office) VALUES (#{name}, #{releaseDate}, #{leadActor},#{boxOffice})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Movie movie);

    @Update("UPDATE movies SET name = #{name}, release_Date = #{releaseDate}, lead_Actor = #{leadActor}, box_Office = #{boxOffice} WHERE id = #{id}")
    void update(Movie movie);

    @Delete("DELETE FROM movies WHERE id = #{id}")
    void delete(Integer id);
}

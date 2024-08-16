package com.example.movie_list.dao;

import com.example.movie_list.entity.Movie;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DBRider
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class MovieListMapperTest {

    @Autowired
    private MovieListMapper movieListMapper;

    @Test
    @DataSet(value = "datasets/movies.yml")
    @Transactional
    void すべての映画リストが取得できること() {
        List<Movie> movies = movieListMapper.findAll();
        assertThat(movies)
                .hasSize(4)
                .contains(
                        new Movie(1, "ホーム　アローン", LocalDate.of(1991, 06, 22), "マコーレ　カルキン", 476684675),
                        new Movie(2, "タイタニック", LocalDate.of(1997, 12, 20), "レオナルド　ディカプリオ", 658532551),
                        new Movie(3, "メリーに首ったけ", LocalDate.of(1999, 01, 30), "キャメロン　ディアス", 369884651),
                        new Movie(4, "バック　トゥ　ザ　フューチャー", LocalDate.of(1985, 12, 07), "マイケル　J　フォックス", 210609762)
                );
    }

    @Test
    @DataSet(value = "datasets/movies.yml")
    @Transactional
    void 指定したIDの映画リストが取得できること() {
        Optional<Movie> actual = movieListMapper.findById(1);
        Movie expected = new Movie(1, "ホーム　アローン", LocalDate.of(1991, 6, 22), "マコーレ　カルキン", 476684675);
        assertThat(actual).isPresent();
        assertThat(actual.get()).isEqualTo(expected);
    }

    @Test
    @DataSet(value = "datasets/movies.yml")
    @Transactional
    void 存在しないIDを指定した場合は空のOptionalが返ること() {
        Optional<Movie> movies = movieListMapper.findById(100);
        assertThat(movies).isEmpty();
    }
}

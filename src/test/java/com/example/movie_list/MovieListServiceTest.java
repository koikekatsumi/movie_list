package com.example.movie_list;

import com.example.movie_list.Service.MovieListService;
import com.example.movie_list.dao.MovieListMapper;
import com.example.movie_list.entity.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieListServiceTest {

    @InjectMocks
    private MovieListService movieListService;

    @Mock
    private MovieListMapper movieListMapper;

    @BeforeEach
    void setUp() {
        movieListMapper = mock(MovieListMapper.class);
        movieListService = new MovieListService(movieListMapper);
    }

    @Test
    public void 存在する映画リストのIDを指定したとき正常に映画リストが返されること() throws Exception {
        doReturn(Optional.of(new Movie(1, "ホーム　アローン", LocalDate.of(1991, 06, 22), "マコーレ　カリキン", 476684675))).when(movieListMapper).findById(1);

        Movie actual = movieListService.findMovie(1);
        assertThat(actual).isEqualTo(new Movie(1, "ホーム　アローン", LocalDate.of(1991, 06, 22), "マコーレ　カリキン", 476684675));
    }

    @Test
    public void すべての映画リストが取得できること() {
        List<Movie> movie = List.of(
                new Movie(1, "ホーム　アローン", LocalDate.of(1991, 06, 22), "マコーレ　カリキン", 476684675),
                new Movie(2, "タイタニック", LocalDate.of(1997, 12, 20), "レオナルド　ディカプリオ", 658532551),
                new Movie(3, "メリーに首ったけ", LocalDate.of(1999, 01, 30), "キャメロン　ディアス", 369884651),
                new Movie(4, "バック　トゥ　ザ　フューチャー", LocalDate.of(1985, 12, 07), "マイケル　J　フォックス", 210609762)
        );
        doReturn(movie).when(movieListMapper).findAll();
        List<Movie> actual = movieListService.findAll();
        assertThat(actual).isEqualTo(movie);
        verify(movieListMapper).findAll();
    }

    @Test
    public void 存在しないIDを指定した場合は例外が発生すること() {
        doReturn(Optional.empty()).when(movieListMapper).findById(0);
        assertThatThrownBy(() -> movieListService.findMovie(0))
                .isInstanceOf(MovieListNotFoundException.class);
        verify(movieListMapper).findById(0);
    }

    @Test
    public void 新しい映画リストを登録すること() {
        Movie movie = new Movie("パイレーツ　オブ　カリビアン", LocalDate.of(2003, 07, 18), "ジョニー　デップ", 654264015);
        assertThat(movieListService.insert("パイレーツ　オブ　カリビアン", LocalDate.of(2003, 07, 18), "ジョニー　デップ", 654264015)).isEqualTo(movie);
        verify(movieListMapper).insert(movie);
    }

    @Test
    public void 存在する映画リストを削除すること() {
        int validId = 4;
        Movie existingMovie = new Movie(4, "バック　トゥ　ザ　フューチャー", LocalDate.of(1985, 12, 7), "マイケル　J　フォックス", 210609762);
        when(movieListMapper.findById(4)).thenReturn(Optional.of(existingMovie));
        movieListService.delete(validId);
        verify(movieListMapper).delete(validId);
    }

    @Test
    public void 指定したIDに映画リストがない場合は削除できないこと() {
        int invalidId = 100;
        when(movieListMapper.findById(invalidId)).thenReturn(Optional.empty());
        Exception exception = assertThrows(MovieListNotFoundException.class, () -> {
            movieListService.delete(100);
        });
        assertEquals("Movie with id " + invalidId + " not found", exception.getMessage());
        verify(movieListMapper, never()).delete(invalidId);
    }
}

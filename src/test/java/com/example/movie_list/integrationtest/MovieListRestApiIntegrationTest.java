package com.example.movie_list.integrationtest;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@DBRider
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MovieListRestApiIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DataSet(value = "datasets/movies.yml")
    @Transactional
    void データベースに登録されている映画リストが全件取得できること() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/movies"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                        [
                            {
                                "id": 1,
                                "name": "ホーム　アローン",
                                "releaseDate": "1991-06-22",
                                "leadActor": "マコーレ　カルキン",
                                "boxOffice": 476684675
                            },
                            {
                                "id": 2,
                                "name": "タイタニック",
                                "releaseDate": "1997-12-20",
                                "leadActor": "レオナルド　ディカプリオ",
                                "boxOffice": 658532551
                            },
                            {
                                "id": 3,
                                "name": "メリーに首ったけ",
                                "releaseDate": "1999-01-30",
                                "leadActor": "キャメロン　ディアス",
                                "boxOffice": 369884651
                            },
                            {
                                "id": 4,
                                "name": "バック　トゥ　ザ　フューチャー",
                                "releaseDate": "1985-12-07",
                                "leadActor": "マイケル　J　フォックス",
                                "boxOffice": 210609762
                            }
                        ]
                        """));
    }

    @Test
    @DataSet(value = "datasets/movies.yml")
    @Transactional
    void 指定したIDの映画リストが存在する時にその映画リストを取得できること() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/movies/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {
                            "id": 1,
                            "name": "ホーム　アローン",
                            "releaseDate": "1991-06-22",
                            "leadActor": "マコーレ　カルキン",
                            "boxOffice": 476684675
                        },
                                            """));
    }

    @Test
    @DataSet(value = "datasets/movies.yml")
    @Transactional
    void 指定したIDの映画リストが存在しない時に例外処理が発生すること() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/movies/100"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

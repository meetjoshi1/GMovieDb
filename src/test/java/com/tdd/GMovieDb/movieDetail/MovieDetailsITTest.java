package com.tdd.GMovieDb.movieDetail;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tdd.GMovieDb.movie.MovieEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class MovieDetailsITTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    MovieDetailsRepository movieDetailsRepository;

    ObjectMapper objectMapper;

    @BeforeEach
    public void setUp(){
        objectMapper = new ObjectMapper();
    }

    @Test
    public void getAllMovieDetails() throws Exception {

        MovieDetailsDto movieDetailsDto = new MovieDetailsDto("TheAvengers", "Joss Whedon",
                                                                     "Jr. Robert",
                                                                    "2012",
                                                                    "Earth's mightiest heroes",
                                                                    null);

        MovieDetailsEntity movieEntity = new MovieDetailsEntity(movieDetailsDto.getTitle(), movieDetailsDto.getDirector(),
                                                                movieDetailsDto.getActors(), movieDetailsDto.getRelease(),
                                                                movieDetailsDto.getDescription(), movieDetailsDto.getRating());

        MovieDetailsEntity expected = movieDetailsRepository.save(movieEntity);

        String expectedEntity = objectMapper.writeValueAsString(expected);


        String actualEntity = mockMvc.perform(get("/movieDetails/{title}", movieDetailsDto.getTitle()))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertThat(expectedEntity).isEqualTo(actualEntity);
    }
}

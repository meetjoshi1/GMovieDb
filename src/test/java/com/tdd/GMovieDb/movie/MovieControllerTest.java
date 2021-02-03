package com.tdd.GMovieDb.movie;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MovieControllerTest {

    @Mock
    MovieRepository movieRepository;

    @InjectMocks
    MovieService movieService;

    @Test
    public void addMovie(){
        MovieDto movieDto = new MovieDto("Unbreakable");
        movieService.addMovieList(movieDto);
        verify(movieRepository).save(new MovieEntity(movieDto.getMovieName()));
    }

    @Test
    public void getMovieList(){
        when(movieRepository.findAll()).thenReturn(List.of(new MovieEntity("Unbreakable")));

        List<MovieDto> expectedMovieList = movieRepository.findAll()
                                                           .stream()
                                                           .map(movieEntity -> {
                                                               return new MovieDto(movieEntity.getMovieName());
                                                           })
                                                           .collect(Collectors.toList());

        List<MovieDto> actualMovieList = movieService.getMovieList();

        assertThat(actualMovieList).isEqualTo(expectedMovieList);
    }
}

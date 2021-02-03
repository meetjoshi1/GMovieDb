package com.tdd.GMovieDb.movie;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

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
}

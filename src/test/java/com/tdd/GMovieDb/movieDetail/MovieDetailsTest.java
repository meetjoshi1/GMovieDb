package com.tdd.GMovieDb.movieDetail;

import com.tdd.GMovieDb.movie.MovieDto;
import com.tdd.GMovieDb.movie.MovieEntity;
import com.tdd.GMovieDb.movie.MovieRepository;
import com.tdd.GMovieDb.movie.MovieService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MovieDetailsTest {

    @Mock
    MovieDetailsRepository movieDetailsRepository;

    @InjectMocks
    MovieDetailsService movieDetailsService;

    @Test
    public void addMovie(){
        MovieDetailsDto movieDetailsDto = new MovieDetailsDto("TheAvengers", "Joss Whedon",
                                                                "Jr. Robert",
                                                                "2012",
                                                                "Earth's mightiest heroes",
                                                                null);
        movieDetailsService.addMovieDetails(movieDetailsDto);
        verify(movieDetailsRepository).save(new MovieDetailsEntity(movieDetailsDto.getTitle(), movieDetailsDto.getDirector(),
                movieDetailsDto.getActors(), movieDetailsDto.getRelease(),
                movieDetailsDto.getDescription(), movieDetailsDto.getRating()));
    }
}

package com.tdd.GMovieDb.movie;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> getMovieList() {
        List<MovieDto> collect = movieRepository.findAll()
                .stream()
                .map(movieEntity -> new MovieDto(movieEntity.getMovieName()))
                .collect(Collectors.toList());

        return collect;
    }

    public void addMovieList(MovieDto movieDto) {
        movieRepository.save(new MovieEntity(movieDto.getMovieName()));
    }
}

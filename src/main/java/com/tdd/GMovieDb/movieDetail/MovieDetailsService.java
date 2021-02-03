package com.tdd.GMovieDb.movieDetail;

import org.springframework.stereotype.Service;

@Service
public class MovieDetailsService {

    MovieDetailsRepository movieDetailsRepository;

    public MovieDetailsService(MovieDetailsRepository movieDetailsRepository) {
        this.movieDetailsRepository = movieDetailsRepository;
    }

    public MovieDetailsDto getMovieDetailsByTitle(String title) {

        for (MovieDetailsEntity movieDetailsByName : movieDetailsRepository.findAll()) {

            if (movieDetailsByName.getTitle().equals(title)) {
                return new MovieDetailsDto(movieDetailsByName.getTitle(),movieDetailsByName.getDirector(),movieDetailsByName.getActors(),
                        movieDetailsByName.getRelease(),movieDetailsByName.getDescription(),movieDetailsByName.getRating()
                );
            }
        }
        throw new RuntimeException("Movie doesn't exist");
    }


    public MovieDetailsDto addMovieDetails(MovieDetailsDto movieDetailsDto) {

        MovieDetailsEntity movieEntity = new MovieDetailsEntity(movieDetailsDto.getTitle(), movieDetailsDto.getDirector(),
                movieDetailsDto.getActors(), movieDetailsDto.getRelease(),
                movieDetailsDto.getDescription(), movieDetailsDto.getRating());

        movieDetailsRepository.save(movieEntity);

        return movieDetailsDto;

    }
}


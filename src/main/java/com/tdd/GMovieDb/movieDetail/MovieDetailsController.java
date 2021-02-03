package com.tdd.GMovieDb.movieDetail;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieDetailsController {

    MovieDetailsService movieDetailsService;

    public MovieDetailsController(MovieDetailsService movieDetailsService) {
        this.movieDetailsService = movieDetailsService;
    }

    @PostMapping("/movieDetails")
    public ResponseEntity<MovieDetailsDto> getMovieDetailsByTitle(MovieDetailsDto movieDetailsDto){
        System.out.println(movieDetailsDto);
        return new ResponseEntity<MovieDetailsDto>(movieDetailsService.addMovieDetails(movieDetailsDto), HttpStatus.CREATED);
    }

    @GetMapping("movieDetails/{title}")
    public ResponseEntity<MovieDetailsDto> getMovieDetailsByTitle(@PathVariable String title){
            return new ResponseEntity<MovieDetailsDto>(movieDetailsService.getMovieDetailsByTitle(title), HttpStatus.OK);
    }
}



package com.tdd.GMovieDb.movie;

import lombok.Value;

public class MovieDto {
    String movieName;

    public MovieDto(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}



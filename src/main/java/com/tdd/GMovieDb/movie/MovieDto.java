package com.tdd.GMovieDb.movie;

import lombok.Value;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieDto)) return false;
        MovieDto movieDto = (MovieDto) o;
        return Objects.equals(getMovieName(), movieDto.getMovieName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMovieName());
    }
}



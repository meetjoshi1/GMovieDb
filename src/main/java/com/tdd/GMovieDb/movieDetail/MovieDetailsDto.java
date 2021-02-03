package com.tdd.GMovieDb.movieDetail;

import com.tdd.GMovieDb.movie.MovieDto;
import lombok.Value;

import java.util.List;
import java.util.Objects;

public class MovieDetailsDto {

    private  String title;
    private  String director;
    private  String actors;
    private  String release;
    private  String description;
    private  String rating;

    public MovieDetailsDto() {
    }

    public MovieDetailsDto(String title, String director, String actors, String release, String description, String rating) {
        this.title = title;
        this.director = director;
        this.actors = actors;
        this.release = release;
        this.description = description;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieDetailsDto)) return false;
        MovieDetailsDto that = (MovieDetailsDto) o;
        return Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getDirector(), that.getDirector()) &&
                Objects.equals(getActors(), that.getActors()) &&
                Objects.equals(getRelease(), that.getRelease()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getRating(), that.getRating());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getDirector(), getActors(), getRelease(), getDescription(), getRating());
    }
}

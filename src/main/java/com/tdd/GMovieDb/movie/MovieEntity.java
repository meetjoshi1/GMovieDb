package com.tdd.GMovieDb.movie;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String movieName;

    public MovieEntity(String movieName) {
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
        if (!(o instanceof MovieEntity)) return false;
        MovieEntity that = (MovieEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(getMovieName(), that.getMovieName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getMovieName());
    }
}

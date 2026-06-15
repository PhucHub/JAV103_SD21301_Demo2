package com.jav103.jav103_sum26_demo2.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "director")
    private String director;

    @Column(name = "genre")
    private String genre;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MovieSchedule> movieSchedules = new ArrayList<>();

    public Movie() {
    }

    public Movie(Long id, String title, String director, String genre, Integer releaseYear, Double rating, String status) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<MovieSchedule> getMovieSchedules() {
        return movieSchedules;
    }

    public void setMovieSchedules(List<MovieSchedule> movieSchedules) {
        this.movieSchedules = movieSchedules;
    }

    public void addMovieSchedule(MovieSchedule movieSchedule) {
        this.movieSchedules.add(movieSchedule);
        movieSchedule.setMovie(this);
    }

    public void removeMovieSchedule(MovieSchedule movieSchedule) {
        this.movieSchedules.remove(movieSchedule);
        movieSchedule.setMovie(null);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseYear=" + releaseYear +
                ", rating=" + rating +
                ", status='" + status + '\'' +
                '}';
    }
}

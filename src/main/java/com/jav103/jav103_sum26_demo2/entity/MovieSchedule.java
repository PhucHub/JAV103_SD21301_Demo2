package com.jav103.jav103_sum26_demo2.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movie_schedules")
public class MovieSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @Column(name = "schedule_date_time")
    private LocalDateTime scheduleDatetime;

    @Column(name = "room")
    private String room;

    @Column(name = "ticket_price")
    private Double ticketPrice;

    public MovieSchedule() {
    }

    public MovieSchedule(Long id, Movie movie, LocalDateTime scheduleDatetime, String room, Double ticketPrice) {
        this.id = id;
        this.movie = movie;
        this.scheduleDatetime = scheduleDatetime;
        this.room = room;
        this.ticketPrice = ticketPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getScheduleDatetime() {
        return scheduleDatetime;
    }

    public void setScheduleDatetime(LocalDateTime scheduleDatetime) {
        this.scheduleDatetime = scheduleDatetime;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "MovieSchedule{" +
                "id=" + id +
                ", scheduleDatetime=" + scheduleDatetime +
                ", room='" + room + '\'' +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}

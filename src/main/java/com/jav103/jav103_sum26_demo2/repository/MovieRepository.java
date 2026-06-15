package com.jav103.jav103_sum26_demo2.repository;

import com.jav103.jav103_sum26_demo2.entity.Movie;
import com.jav103.jav103_sum26_demo2.utils.EntityManagerUtils;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MovieRepository {

    public List<Movie> getMovies() {
        try (EntityManager em = EntityManagerUtils.getEntityManager()) {
            return em.createQuery("select m from Movie m", Movie.class).getResultList();
        }
    }

    public Movie getMovieById(Long id) {
        try (EntityManager em = EntityManagerUtils.getEntityManager()) {
            return em.find(Movie.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteMovie(Long id) {
        try (EntityManager em = EntityManagerUtils.getEntityManager()) {
            em.getTransaction().begin();
            Movie movie = em.find(Movie.class, id);
            if (movie != null) {
                em.remove(movie);
            }
            em.getTransaction().commit();
        }
    }

    public void addMovie(Movie movie) {
        try (EntityManager em = EntityManagerUtils.getEntityManager()) {
            em.getTransaction().begin();
            em.persist(movie);
            em.getTransaction().commit();
        }
    }

    public void editMovie(Movie movie) {
        try (EntityManager em = EntityManagerUtils.getEntityManager()) {
            em.getTransaction().begin();
            em.merge(movie);
            em.getTransaction().commit();
        }
    }
}

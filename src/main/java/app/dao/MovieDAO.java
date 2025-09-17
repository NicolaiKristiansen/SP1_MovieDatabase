package app.dao;

import app.entities.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class MovieDAO implements IDAO<Movie, Integer>{
    private EntityManagerFactory emf;

    public MovieDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Movie create(Movie movie) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(movie);
            em.getTransaction().commit();
            return movie;
        }
    }

    @Override
    public Movie read(Integer id) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Movie foundMovie = em.find(Movie.class, id);
            em.getTransaction().commit();
            return foundMovie;
        }
    }

    @Override
    public Movie update(Movie movie) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().commit();
            Movie updatedMovie = em.merge(movie);
            em.getTransaction().commit();
            return updatedMovie;
        }
    }

    @Override
    public Movie delete(Integer id) {
        try(EntityManager em = emf.createEntityManager()) {
            Movie deleteMovie = read(id);
            em.getTransaction().commit();
            em.remove(deleteMovie);
            em.getTransaction().commit();
            return deleteMovie;
        }
    }
}

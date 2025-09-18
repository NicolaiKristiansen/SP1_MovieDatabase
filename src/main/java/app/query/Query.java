package app.query;

import app.entities.Genre;
import app.entities.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;

public class Query {

    EntityManagerFactory emf;

    public Query(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<Movie> getTop10Movies(){
        try(EntityManager em = emf.createEntityManager()){
            return em.createQuery("select m from Movie m order by m.voteRating desc", Movie.class).setMaxResults(10).getResultList();
        }
    }

    public List<Movie> getBottom10Movies(){
        try(EntityManager em = emf.createEntityManager()){
            return em.createQuery("select m from Movie m order by m.voteRating asc", Movie.class).setMaxResults(10).getResultList();
        }
    }

    public List<Movie> searchByKeyWord(String searchword){
        try(EntityManager em = emf.createEntityManager()){
            return em.createQuery("select m from Movie m where lower(m.title) like lower(:searchword)", Movie.class)
                    .setParameter("searchword", "%" + searchword + "%")
                    .getResultList();
        }
    }

    public List<Movie> getAllMoviesSharingAGenre(Genre genre){
        try(EntityManager em = emf.createEntityManager()){
            return em.createQuery("select m from Movie m where :genre member of m.genres", Movie.class)
                    .setParameter("genre", genre)
                    .getResultList();
        }
    }
}

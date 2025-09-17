package app;

import app.config.HibernateConfig;
import app.dtos.GenreDTO;
import app.dtos.GenreResponeDTO;
import app.dtos.MovieDTO;
import app.dtos.MovieResponseDTO;
import app.entities.Movie;
import app.services.DTOToEntityConverter;
import app.services.GenreService;
import app.services.MovieServices;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Beer Demo");
/*
        MovieServices ms = new MovieServices();
        MovieResponseDTO movie = ms.getMoviesFromAPI();
        System.out.println(movie);

*/
        GenreService gs = new GenreService();
        GenreResponeDTO genreResponseDTO = gs.getGenreFromAPI();
        System.out.println(genreResponseDTO);


        MovieServices movieServices = new MovieServices();
        List<MovieDTO> movies = movieServices.getMoviesFromAPI().getResults();
        List<Movie> movieEntity = new ArrayList<>();
        DTOToEntityConverter dtoToEntityConverter = new DTOToEntityConverter(HibernateConfig.getEntityManagerFactory());
        for(MovieDTO movie: movies){
            movieEntity.add(dtoToEntityConverter.movieDTOToEntity(movie));
        }

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
        for (Movie movie: movieEntity){
            try(EntityManager em = emf.createEntityManager()){
                em.getTransaction().begin();
                em.persist(movie);
                em.getTransaction().commit();
            }

        }


    }
}
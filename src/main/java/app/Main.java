package app;

import app.config.HibernateConfig;
import app.daos.MovieDAO;
import app.dtos.*;
import app.entities.Movie;
import app.entities.People;
import app.services.DTOToEntityConverter;
import app.services.GenreService;
import app.services.MovieServices;
import app.services.PeopleServices;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
        PeopleServices ps = new PeopleServices();
        MovieDAO mDAO = new MovieDAO(emf);

        System.out.println("Beer Demo");

        MovieServices ms = new MovieServices();
        MovieResponseDTO movieResponseDTO = ms.getMoviesFromAPI();

        DTOToEntityConverter dtoToEntityConverter = new DTOToEntityConverter();
       List<Movie> m = dtoToEntityConverter.convertMovieResponseToEntities(movieResponseDTO);

       for(Movie m1: m){
           int movieId = m1.getMovieId();

           PeopleResponseDTO peopleResponseDTO = ps.getPeopleFromDTO(movieId);
           List<People> p = dtoToEntityConverter.convertPeopleResponseToEntities(peopleResponseDTO);
           for(People people : p){
               m1.addPeople(people);
           }

       }


        for(Movie m2 : m){
            mDAO.createMovie(m2);
        }
       /*
        GenreService gs = new GenreService();
        GenreResponeDTO genreResponseDTO = gs.getGenreFromAPI();
        System.out.println(genreResponseDTO);


 */

        emf.close();
    }
}
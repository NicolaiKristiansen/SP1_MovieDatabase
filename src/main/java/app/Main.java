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


        MovieServices movieServices = new MovieServices();

        movieServices.getAllMoviesWithPeople(emf);
       /*
        GenreService gs = new GenreService();
        GenreResponeDTO genreResponseDTO = gs.getGenreFromAPI();
        System.out.println(genreResponseDTO);


 */

        emf.close();
    }
}
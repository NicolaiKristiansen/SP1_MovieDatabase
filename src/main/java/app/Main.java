package app;

import app.config.HibernateConfig;
import app.dao.MovieDAO;
import app.dtos.*;
import app.entities.Genre;
import app.entities.Movie;
import app.entities.People;
import app.query.Query;
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

        Query query = new Query(emf);
        System.out.println("--- Top 10 ---");
        query.getTop10Movies().forEach(System.out::println);
        System.out.println("--- Bottom 10 ---");
        query.getBottom10Movies().forEach(System.out::println);
        System.out.println("--- Movies with searchword in title ---");
        query.searchByKeyWord("De").forEach(System.out::println);
        System.out.println("--- Get all movies sharing a genre ---");
        //TODO: We need  a genre object, best to get it from the database
       // query.getAllMoviesSharingAGenre();
       /*
        GenreService gs = new GenreService();
        GenreResponeDTO genreResponseDTO = gs.getGenreFromAPI();
        System.out.println(genreResponseDTO);


 */

        emf.close();
    }
}
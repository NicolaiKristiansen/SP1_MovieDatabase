package app;

import app.config.HibernateConfig;
import app.services.MovieServices;
import jakarta.persistence.EntityManagerFactory;

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
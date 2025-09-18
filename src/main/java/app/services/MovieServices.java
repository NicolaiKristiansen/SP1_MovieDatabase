package app.services;

import app.dao.MovieDAO;
import app.dtos.MovieResponseDTO;
import app.dtos.PeopleResponseDTO;
import app.entities.Movie;
import app.entities.People;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;



public class MovieServices {
    ApiServices apiServices = new ApiServices();
    String token = System.getenv("token");

    public MovieResponseDTO getMoviesFromAPI(){
        String uri = "https://api.themoviedb.org/3/discover/movie?language=da&page=1&region=DK&sort_by=popularity.desc&with_original_language=da&primary_release_date.gte=2020-09-15";
       return apiServices.fetchData(token, uri, MovieResponseDTO.class);
    }


    public void getAllMoviesWithPeople(EntityManagerFactory emf) {
        PeopleServices ps = new PeopleServices();
        MovieDAO mDAO = new MovieDAO(emf);

        MovieResponseDTO movieResponseDTO = getMoviesFromAPI();

        DTOToEntityConverter dtoToEntityConverter = new DTOToEntityConverter();
        List<Movie> m = dtoToEntityConverter.convertMovieResponseToEntities(movieResponseDTO);

        for (Movie m1 : m) {
            int movieId = m1.getMovieId();
            PeopleResponseDTO peopleResponseDTO = ps.getPeopleFromDTO(movieId);
            List<People> p = dtoToEntityConverter.convertPeopleResponseToEntities(peopleResponseDTO);
            for (People people : p) {
                m1.addPeople(people);
            }

        }
        for (Movie m2 : m) {
            mDAO.create(m2);
        }
    }
}

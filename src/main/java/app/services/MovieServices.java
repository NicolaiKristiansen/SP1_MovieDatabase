package app.services;

import app.dao.MovieDAO;
import app.dtos.MovieResponseDTO;
import app.dtos.PeopleResponseDTO;
import app.entities.Movie;
import app.entities.People;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;



public class MovieServices {
    ApiServices apiServices = new ApiServices();
    String token = System.getenv("token");

    public MovieResponseDTO getMoviesFromAPI(int page){
        String uri = "https://api.themoviedb.org/3/discover/movie?language=da&page="+page+"&region=DK&sort_by=popularity.desc&with_original_language=da&primary_release_date.gte=2020-09-15";
       return apiServices.fetchData(token, uri, MovieResponseDTO.class);
    }


    public void getAllMoviesWithPeople(EntityManagerFactory emf) {
        PeopleServices ps = new PeopleServices();
        MovieDAO mDAO = new MovieDAO(emf);
        DTOToEntityConverter dtoToEntityConverter = new DTOToEntityConverter();
        MovieResponseDTO movieResponseDTO = getMoviesFromAPI(1);

        List<Movie> m = new ArrayList<>();
        m.addAll(dtoToEntityConverter.convertMovieResponseToEntities(movieResponseDTO));

        for(int i = 2; i <= movieResponseDTO.getTotal_pages(); i++){
            movieResponseDTO = getMoviesFromAPI(i);
            m.addAll(dtoToEntityConverter.convertMovieResponseToEntities(movieResponseDTO));
        }



        for (Movie m1 : m) {
            int movieId = m1.getMovieId();
            PeopleResponseDTO peopleResponseDTO = ps.getPeopleFromDTO(movieId);
            List<People> p = dtoToEntityConverter.convertPeopleResponseToEntities(peopleResponseDTO);
            p.forEach(System.out::println);


            //List<People>FilterPeople = p.stream().filter(people -> "Actor".equalsIgnoreCase(people.getDepartment())|| "Director".equalsIgnoreCase(people.getDepartment())).toList();
            for (People people : p) {
                m1.addPeople(people);
            }

        }
        for (Movie m2 : m) {
            mDAO.create(m2);
        }
    }
}

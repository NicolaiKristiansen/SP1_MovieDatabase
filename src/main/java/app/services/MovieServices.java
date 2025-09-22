package app.services;

import app.dao.MovieDAO;
import app.dtos.GenreResponeDTO;
import app.dtos.MovieDTO;
import app.dtos.MovieResponseDTO;
import app.dtos.PeopleResponseDTO;
import app.entities.Genre;
import app.entities.Movie;
import app.entities.People;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


public class MovieServices {
    ApiServices apiServices = new ApiServices();
    String token = System.getenv("token");

    public MovieResponseDTO getMoviesFromAPI(int page){
            String uri = "https://api.themoviedb.org/3/discover/movie?language=da&page="+page+"&region=DK&sort_by=popularity.desc&with_original_language=da&primary_release_date.gte=2020-09-15";
            return apiServices.fetchData(token, uri, MovieResponseDTO.class);
    }


    public void getMoviesWithPeoplesAndGenres(EntityManagerFactory emf) {
        GenreService gs = new GenreService();
        //Get our genres from an api
        GenreResponeDTO genreResponeDTO = gs.getGenreFromAPI();
        DTOToEntityConverter dtoToEntityConverter = new DTOToEntityConverter();
        //Take the list in the GenreResponseDTO and turn them into dto's and then to an entity
        List<Genre> g = dtoToEntityConverter.convertGenreToEntities(genreResponeDTO);

        //Save the genres to our database
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            for (Genre genre : g) {
                em.persist(genre);
            }
            em.getTransaction().commit();
        }

        PeopleServices ps = new PeopleServices();
        MovieDAO mDAO = new MovieDAO(emf);
        //get page one of movies that are danish and released in the last 5 years
        MovieResponseDTO movieResponseDTO = getMoviesFromAPI(1);

        //Go through ever page returned by the api
        for(int i = 1; i <= movieResponseDTO.getTotal_pages(); i++){
            for (MovieDTO m1 : movieResponseDTO.getResults()) {
                //Get the list of integers representing genres
                List<Integer> genreIds = m1.getGenre().stream().toList();
                //Make the movieDTO into a Entity so we can save it
                Movie m = dtoToEntityConverter.convertMovieResponseToEntity(m1);

                int movieId = m1.getId();
                //Get the response of people that have worked on the movie from an api
                PeopleResponseDTO peopleResponseDTO = ps.getPeopleFromDTO(movieId);
                //Get the list of peopleDTO from the response and turn them into a Set of people entitys
                Set<People> p = dtoToEntityConverter.convertPeopleResponseToEntities(peopleResponseDTO);
                //Filter out list of people working on the movie to only have actors and directors
                Set<People> filterPeople = p.stream()
                        .filter(people ->
                                "Acting".equalsIgnoreCase(people.getDepartment())
                                ||
                                "Directing".equalsIgnoreCase(people.getDepartment()))
                        .collect(Collectors.toSet());

                //Now that we have a set of people we can add it to the movie entity
                for (People people : filterPeople) {
                    m.addPeople(people);
                }
                //Here we use the genreIDs to make a Genre entity object to add to the movie entity
                for(Integer genreId : genreIds) {
                    Optional<Genre> genre = g.stream()
                            .filter(id -> id.getGenreId() == genreId)
                            .findFirst();

                    m.addGenre(genre.orElse(null));
                }
                //Finally we persist the movie entity after giving it all the information it needs
                mDAO.create(m);

            }
            //At the end of the loop we go to the next page
            movieResponseDTO = getMoviesFromAPI(i);
        }
    }
}

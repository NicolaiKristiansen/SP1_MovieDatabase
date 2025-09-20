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

        GenreResponeDTO genreResponeDTO = gs.getGenreFromAPI();
        DTOToEntityConverter dtoToEntityConverter = new DTOToEntityConverter();

        List<Genre> g = dtoToEntityConverter.convertGenreToEntities(genreResponeDTO);

        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            for (Genre genre : g) {
                em.persist(genre);
            }
            em.getTransaction().commit();
        }

        PeopleServices ps = new PeopleServices();
        MovieDAO mDAO = new MovieDAO(emf);

        MovieResponseDTO movieResponseDTO = getMoviesFromAPI(1);


        for(int i = 1; i <= movieResponseDTO.getTotal_pages(); i++){
            for (MovieDTO m1 : movieResponseDTO.getResults()) {
                List<Integer> genreIds = m1.getGenre().stream().toList();

                Movie m = dtoToEntityConverter.convertMovieResponseToEntity(m1);

                int movieId = m1.getId();
                PeopleResponseDTO peopleResponseDTO = ps.getPeopleFromDTO(movieId);

                Set<People> p = dtoToEntityConverter.convertPeopleResponseToEntities(peopleResponseDTO);
                Set<People> filterPeople = p.stream()
                        .filter(people ->
                                "Acting".equalsIgnoreCase(people.getDepartment())
                                ||
                                "Directing".equalsIgnoreCase(people.getDepartment()))
                        .collect(Collectors.toSet());

                for (People people : filterPeople) {
                    m.addPeople(people);
                }
                for(Integer genreId : genreIds) {
                    Optional<Genre> genre = g.stream()
                            .filter(id -> id.getGenreId() == genreId)
                            .findFirst();

                    m.addGenre(genre.orElse(null));
                }

                mDAO.create(m);

            }
            movieResponseDTO = getMoviesFromAPI(i);
        }
    }
}

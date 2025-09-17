package app.services;

import app.dtos.GenreDTO;
import app.dtos.MovieDTO;
import app.dtos.PeopleDTO;
import app.dtos.PeopleResponseDTO;
import app.entities.Genre;
import app.entities.Movie;
import app.entities.People;
import jakarta.persistence.*;

import java.util.*;

public class DTOToEntityConverter {
    public EntityManagerFactory emf;

    public DTOToEntityConverter(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Movie movieDTOToEntity(MovieDTO movieDTO){

       List<Integer> genreId = movieDTO.getGenre();
       Set<GenreDTO> genreDTOS = new HashSet<>();

       for (Integer id: genreId){
           try(EntityManager em = emf.createEntityManager()){
               Query query = em.createQuery("select g from Genre g where g.id=:movieID");
               query.setParameter("movieID", id);
               Genre genre = (Genre) query.getSingleResult();
               GenreDTO genreDTO = new GenreDTO(genre.getGenreId(), genre.getName());
               genreDTOS.add(genreDTO);
           }
       }

       int movieID = movieDTO.getId();
       PeopleServices peopleServices = new PeopleServices();
       List<PeopleDTO> peopleDTOS = peopleServices.getPeopleFromDTO(movieID).getResults();



        Movie movie = Movie.builder()
                .title(movieDTO.getTitle())
                .language(movieDTO.getLanguage())
                .releaseDate(movieDTO.getReleaseDate())
                .voteRating(movieDTO.getVoteRating())
                .genres(genreDTOToEntity(genreDTOS))
                .people(peopleDTOToEntity(peopleDTOS))
                .build();
        return movie;
    }

    private Set<Genre> genreDTOToEntity(Set<GenreDTO> genreDTO){
        Set<Genre> genreEntityList = new HashSet<>();
    for(GenreDTO genre: genreDTO){
         Genre genreEntity = Genre.builder()
                .id(genre.getId())
                .name(genre.getName())
                .build();
         genreEntityList.add(genreEntity);
                }
        return genreEntityList;
    }

    private Set<People> peopleDTOToEntity(List<PeopleDTO> peopleDTOList){
        People people = null;
        Set<People> peopleList = new HashSet<>();
        for (PeopleDTO peopleDTO: peopleDTOList) {
            people = People.builder()
                    .name(peopleDTO.getName())
                    .gender(peopleDTO.getGender())
                    .department(peopleDTO.getKnowForDepartment())
                    .build();
            peopleList.add(people);
        }
        return peopleList;
    }
}

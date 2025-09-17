package app.services;

import app.dtos.*;
import app.entities.Movie;
import app.entities.People;

import java.util.List;
import java.util.stream.Collectors;

public class DTOToEntityConverter {

    public Movie movieDTOToEntity(MovieDTO movieDTO){
        Movie movie = Movie.builder()
                .movieId(movieDTO.getId())
                .title(movieDTO.getTitle())
                .language(movieDTO.getLanguage())
                .releaseDate(movieDTO.getReleaseDate())
                .voteRating(movieDTO.getVoteRating())
                .build();
        return movie;
    }

    public List<Movie> convertMovieResponseToEntities(MovieResponseDTO movieResponseDTO) {

        List<MovieDTO> movieListDTO = movieResponseDTO.getResults();

        return movieListDTO.stream()
                .map(this::movieDTOToEntity)
                .collect(Collectors.toList());
    }





/*
    public Genre genreDTOToEntity(GenreDTO genreDTO){
        Genre genre = Genre.builder()
                .id(genreDTO.getID())
                .name(genreDTO.getName())
                .build();
        return genre;
    }

 */

    public People peopleDTOToEntity(PeopleDTO peopleDTO){
        People people = People.builder()
                .name(peopleDTO.getName())
                .gender(peopleDTO.getGender())
                .department(peopleDTO.getKnowForDepartment())
                .build();
        return people;
    }

    public List<People> convertPeopleResponseToEntities(PeopleResponseDTO peopleResponseDTO) {

        List<PeopleDTO> peopleListDTO = peopleResponseDTO.getCast();

        return peopleListDTO.stream()
                .map(this::peopleDTOToEntity)
                .collect(Collectors.toList());
    }


}

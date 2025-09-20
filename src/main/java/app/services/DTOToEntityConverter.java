package app.services;


import app.dtos.*;
import app.entities.Movie;
import app.entities.People;

import java.util.List;
import java.util.stream.Collectors;

import app.dtos.GenreDTO;
import app.dtos.MovieDTO;
import app.dtos.PeopleDTO;
import app.entities.Genre;
import app.entities.Movie;
import app.entities.People;

import java.util.HashSet;
import java.util.Set;


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

    public Movie convertMovieResponseToEntity(MovieDTO movieDTO) {

        return Movie.builder()
                .movieId(movieDTO.getId())
                .title(movieDTO.getTitle())
                .language(movieDTO.getLanguage())
                .releaseDate(movieDTO.getReleaseDate())
                .voteRating(movieDTO.getVoteRating())
                .build();
    }

    //Adding method to convert genreDTO to entity

    public Genre genreDTOToEntity(GenreDTO genreDTO){
        return Genre.builder()
                .genreId(genreDTO.getId())
                .name(genreDTO.getName())
                .build();
    }
    public List<Genre> convertGenreToEntities(GenreResponeDTO genreResponeDTO) {
        List<GenreDTO> genreListDTO = genreResponeDTO.getGenres();

        return genreListDTO.stream()
                .map(this::genreDTOToEntity)
                .collect(Collectors.toList());

    }





/*
    public Genre genreDTOToEntity(GenreDTO genreDTO){
        Genre genre = Genre.builder()
                .id(genreDTO.getId())
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

    public Set<People> convertPeopleResponseToEntities(PeopleResponseDTO peopleResponseDTO) {

        Set<PeopleDTO> peopleListDTO = peopleResponseDTO.getCast();

        return peopleListDTO.stream()
                .map(this::peopleDTOToEntity)
                .collect(Collectors.toSet());
    }


}

package app.services;

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
        Set<Genre> genres = new HashSet<>();
        for (Genre genre: genres){
            genre.getId();
            //TODO: Add a find method for the genre database to construct a Set<Genre> instead of a Set<Integer>
        }
        Movie movie = Movie.builder()
                .title(movieDTO.getTitle())
                .language(movieDTO.getLanguage())
                .releaseDate(movieDTO.getReleaseDate())
                .voteRating(movieDTO.getVoteRating())
                .genres(genres)
                .build();
        return movie;
    }

    public Genre genreDTOToEntity(GenreDTO genreDTO){
        Genre genre = Genre.builder()
                .id(genreDTO.getId())
                .name(genreDTO.getName())
                .build();
        return genre;
    }

    public People peopleDTOToEntity(PeopleDTO peopleDTO){
        People people = People.builder()
                .name(peopleDTO.getName())
                .gender(peopleDTO.getGender())
                .department(peopleDTO.getKnowForDepartment())
                .build();
        return people;
    }
}

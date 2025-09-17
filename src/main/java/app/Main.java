package app;

import app.dtos.GenreDTO;
import app.dtos.GenreResponeDTO;
import app.dtos.MovieDTO;
import app.dtos.MovieResponseDTO;
import app.services.GenreService;
import app.services.MovieServices;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Beer Demo");

        MovieServices ms = new MovieServices();
        MovieResponseDTO movieResponseDTO = ms.getMoviesFromAPI();
        System.out.println(movieResponseDTO);

        /*
        GenreService gs = new GenreService();
        GenreResponeDTO genreResponseDTO = gs.getGenreFromAPI();
        System.out.println(genreResponseDTO);


         */
        //       List<MovieDTO> movieList = movieResponseDTO.getMovieDTO(); // assuming this method exists
/*
        for (int x = 0; x>movieResponseDTO.getResults().size(); x++) {
            movieResponseDTO.getResults().get(x).getId();
            String peopleURI = "https://api.themoviedb.org/3/movie/" + dto.getId() + "/credits";
            System.out.println(peopleURI);
        }

 */


    }
}
/*
    public static class MovieConverter {

        public MovieDTO fromResponseDTO(MovieResponseDTO movieResponseDTO) {
           return MovieDTO.builder()
                   .id(movieResponseDTO.getResults().get(0).getId())
                   .id(movieResponseDTO.getMovieDTO().getId())
                   .title(movieResponseDTO.getMovieDTO().getTitle())
                   .language(movieResponseDTO.getMovieDTO().getLanguage())
                   .releaseDate(movieResponseDTO.getMovieDTO().getReleaseDate())
                   .voteRating(movieResponseDTO.getMovieDTO().getVoteRating())
                   .genre(movieResponseDTO.getMovieDTO().getGenre())
                   .build();
       }
    }


}

         */
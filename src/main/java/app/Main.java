package app;

import app.dtos.GenreDTO;
import app.dtos.GenreResponeDTO;
import app.dtos.MovieDTO;
import app.dtos.MovieResponseDTO;
import app.services.GenreService;
import app.services.MovieServices;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Beer Demo");
/*
        MovieServices ms = new MovieServices();
        MovieResponseDTO movie = ms.getMoviesFromAPI();
        System.out.println(movie);
 */

        GenreService gs = new GenreService();
        GenreResponeDTO genreResponseDTO = gs.getGenreFromAPI();
        System.out.println(genreResponseDTO);

    }
}
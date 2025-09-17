package app.services;

import app.dtos.GenreDTO;
import app.dtos.GenreResponeDTO;

public class GenreService {
    ApiServices apiServices = new ApiServices();
    String token = System.getenv("token");

    public GenreResponeDTO getGenreFromAPI(){
        String uri = "https://api.themoviedb.org/3/genre/movie/list";
        return apiServices.fetchData(token, uri, GenreResponeDTO.class);
    }
}

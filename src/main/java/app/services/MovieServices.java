package app.services;

import app.dtos.MovieResponseDTO;

public class MovieServices {
    ApiServices apiServices = new ApiServices();
    String token = System.getenv("token");

    public MovieResponseDTO getMoviesFromAPI(){
        String uri = "https://api.themoviedb.org/3/discover/movie?language=da&page=1&region=DK&sort_by=popularity.desc&with_original_language=da&primary_release_date.lte=2020-09-15";
       return apiServices.fetchData(token, uri, MovieResponseDTO.class);
    }

}

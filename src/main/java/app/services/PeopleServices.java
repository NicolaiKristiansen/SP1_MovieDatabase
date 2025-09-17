package app.services;

import app.dtos.PeopleResponseDTO;

public class PeopleServices {
    String token = System.getenv("token");
    ApiServices apiServices = new ApiServices();


    public PeopleResponseDTO getPeopleFromDTO(int movieID){

        String uri = "https://api.themoviedb.org/3/genre/movie/list?&language=en-US";
        return apiServices.fetchData(token, uri, PeopleResponseDTO.class);
    }
}

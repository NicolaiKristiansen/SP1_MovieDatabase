package app.services;

import app.dtos.MovieDTO;
import app.dtos.PeopleResponseDTO;

public class PeopleServices {
    String token = System.getenv("token");
    ApiServices apiServices = new ApiServices();
    MovieDTO movieDTO = new MovieDTO();


    public PeopleResponseDTO getPeopleFromDTO(){

        String uri = "";
        return apiServices.fetchData(token, uri, PeopleResponseDTO.class);
    }
}

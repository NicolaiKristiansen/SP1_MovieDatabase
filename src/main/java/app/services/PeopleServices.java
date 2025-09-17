package app.services;

import app.dtos.PeopleResponseDTO;

public class PeopleServices {
    String token = System.getenv("token");
    ApiServices apiServices = new ApiServices();


    public PeopleResponseDTO getPeopleFromDTO(int movieId){
        String uri = "https://api.themoviedb.org/3/movie/"+movieId+"/credits";
        return apiServices.fetchData(token, uri, PeopleResponseDTO.class);
    }


}

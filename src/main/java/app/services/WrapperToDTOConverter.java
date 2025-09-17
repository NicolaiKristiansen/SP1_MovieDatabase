package app.services;

import app.dtos.MovieDTO;

public class WrapperToDTOConverter {

    public MovieDTO fromMovieWrapper(MovieWrapper movieWrapper) {

        return MovieDTO.builder()
                .build();
    }
}

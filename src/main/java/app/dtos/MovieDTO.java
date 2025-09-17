package app.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDTO {

    @JsonSetter("")
    private int id;
    @JsonSetter("")
    private String title;
    @JsonSetter("original_language")
    private String language;
    @JsonSetter("release_date")
    private String releaseDate;
    @JsonSetter("vote_average")
    private double voteRating;
    @JsonSetter("genre_ids")
    private Set<Integer> genre;

}

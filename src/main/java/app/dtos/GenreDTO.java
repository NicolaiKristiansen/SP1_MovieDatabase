package app.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

@JsonIgnoreProperties(ignoreUnknown = true)
public class GenreDTO {

    private int id;
    private String name;

}

package app.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class PeopleDTO {

    private int id;
    private String name;
    private String gender;

    @JsonSetter("known_for_department")
    private String knowForDepartment;

    @JsonSetter("known_for")
    List<MovieDTO> knownFor;
}

package app.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PeopleResponseDTO {
    private int page;
    private Set<PeopleDTO> cast;
    private int total_pages;
    private int total_results;

}

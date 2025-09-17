package app.dtos;

import lombok.Data;

import java.util.List;

@Data
public class PeopleResponseDTO {
    private int page;
    private List<PeopleDTO> results;
    private int total_pages;
    private int total_results;

}

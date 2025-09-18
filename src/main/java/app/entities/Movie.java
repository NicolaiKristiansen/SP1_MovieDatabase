package app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int movieId;
    private String title;
    private String language;
    private String releaseDate;
    private Double voteRating;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @Builder.Default
    @ToString.Exclude
    private Set<Genre> genres = new HashSet<>();
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @Builder.Default
    @ToString.Exclude
    private Set<People> people = new HashSet<>();


    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }

    public void addPeople(People people) {
        this.people.add(people);
    }
}

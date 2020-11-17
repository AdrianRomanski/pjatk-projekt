package pl.pjatk.projekt.model.books;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import pl.pjatk.projekt.model.person.Person;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author extends Person {

    @JsonBackReference
    @OneToMany (mappedBy = "author", fetch = FetchType.EAGER)
    private List<Book> books;

    @Builder
    public Author(String firstName, String lastName, LocalDate ageOfBirth,  List<Book> books) {
        super(firstName, lastName, ageOfBirth);
        this.books = Objects.requireNonNullElseGet(books, ArrayList::new);
    }
}

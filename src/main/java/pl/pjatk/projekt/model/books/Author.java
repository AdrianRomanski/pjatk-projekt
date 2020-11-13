package pl.pjatk.projekt.model.books;

import lombok.*;
import pl.pjatk.projekt.model.BaseEntity;


import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Author extends BaseEntity {

    private String firstName;
    private String lastName;
    private LocalDate ageOfBirth;

    @OneToOne(mappedBy = "author")
    private Book book;

}

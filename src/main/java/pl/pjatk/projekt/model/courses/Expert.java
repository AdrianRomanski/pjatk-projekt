package pl.pjatk.projekt.model.courses;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import pl.pjatk.projekt.model.person.Person;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Expert extends Person {

    private String specialization;

    @OneToMany(mappedBy = "expert")
    private List<Lecture> lectures;

    @Builder
    public Expert(String firstName, String lastName, LocalDate ageOfBirth, String specialization, List<Lecture> lectures) {
        super(firstName, lastName, ageOfBirth);
        this.specialization = specialization;
        this.lectures = Objects.requireNonNullElseGet(lectures, ArrayList::new);
    }
}

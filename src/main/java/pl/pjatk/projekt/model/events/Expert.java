package pl.pjatk.projekt.model.events;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import pl.pjatk.projekt.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Expert extends BaseEntity {

    private String firstName;
    private String lastName;
    private String specialization;

    @JsonBackReference
    @OneToMany(mappedBy = "expert")
    private List<Lecture> lectures;

    @Builder
    public Expert(String firstName, String lastName, String specialization, List<Lecture> lectures) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.lectures = Objects.requireNonNullElseGet(lectures, ArrayList::new);
    }
}

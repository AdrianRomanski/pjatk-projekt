package pl.pjatk.projekt.model.events;

import lombok.*;
import pl.pjatk.projekt.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Expert extends BaseEntity {

    private String firstName;
    private String lastName;
    private String specialization;

    @OneToMany
    private List<Lecture> lectures;
}

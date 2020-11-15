package pl.pjatk.projekt.model.events;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Course extends Event {

    @OneToMany
    private List<Lecture> lectures;
}

package pl.pjatk.projekt.model.events;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course extends Event {

    @OneToMany
    private List<Lecture> lectures;

    @Builder
    public Course(LocalDate eventStarts, LocalDate eventEnds, List<Lecture> lectures) {
        super(eventStarts, eventEnds);
        this.lectures = lectures;
    }
}

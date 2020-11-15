package pl.pjatk.projekt.model.events;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Lecture extends Event{

    @ManyToOne
    @JsonManagedReference
    private Expert expert;

    private String subject;
    private int numberOfLectures;
    private Boolean availableDuringCovid;


    @Builder
    public Lecture(LocalDate eventStarts, LocalDate eventEnds, Expert expert,
                   String subject, int numberOfLectures, Boolean availableDuringCovid) {
        super(eventStarts, eventEnds);
        this.expert = expert;
        this.subject = subject;
        this.numberOfLectures = numberOfLectures;
        this.availableDuringCovid = availableDuringCovid;
    }
}

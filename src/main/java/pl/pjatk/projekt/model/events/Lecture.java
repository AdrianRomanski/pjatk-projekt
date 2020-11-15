package pl.pjatk.projekt.model.events;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Lecture extends Event{

    @ManyToOne
    private Expert lecturer;

    private String subject;
    private int numberOfLectures;
    private Boolean availableDuringCovid;
}

package pl.pjatk.projekt.dto.courses;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.pjatk.projekt.model.person.Person;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class ExpertDTO extends Person {

    private String specialization;
    private List<LectureDTO> lecturesDTO;

    @Builder
    public ExpertDTO(String firstName, String lastName, LocalDate ageOfBirth, String specialization, List<LectureDTO> lecturesDTO) {
        super(firstName, lastName, ageOfBirth);
        this.specialization = specialization;
        this.lecturesDTO = Objects.requireNonNullElseGet(lecturesDTO, ArrayList::new);
    }
}

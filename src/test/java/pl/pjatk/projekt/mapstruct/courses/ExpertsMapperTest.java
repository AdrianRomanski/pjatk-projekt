package pl.pjatk.projekt.mapstruct.courses;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.pjatk.projekt.dto.courses.ExpertDTO;
import pl.pjatk.projekt.model.courses.Expert;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpertsMapperTest {

    ExpertsMapper mapper = new ExpertsMapperImpl();

    @Test
    @DisplayName("Should map object with given values to DTO")
    void expertToExpertDTO() {
        // given
        Expert expert = Expert.builder()
                .specialization("TAK")
                .build();

        // when
        ExpertDTO returnDTO = mapper.expertToExpertDTO(expert);

        // then
        assertEquals(expert.getSpecialization(), returnDTO.getSpecialization());
    }

    @Test
    @DisplayName("Should map object with given values from DTO")
    void expertDTOToExpert() {
        // given
        ExpertDTO expertDTO = ExpertDTO.builder()
                .ageOfBirth(LocalDate.ofYearDay(1905, 14))
                .build();

        // when
        Expert returnObj = mapper.expertDTOToExpert(expertDTO);

        // then
        assertEquals(expertDTO.getAgeOfBirth(), returnObj.getAgeOfBirth());
    }

}

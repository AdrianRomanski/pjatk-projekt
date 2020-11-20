package pl.pjatk.projekt.mapstruct.courses;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.pjatk.projekt.dto.courses.ExpertDTO;
import pl.pjatk.projekt.dto.courses.LectureDTO;
import pl.pjatk.projekt.model.courses.Expert;
import pl.pjatk.projekt.model.courses.Lecture;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpertsMapperTest {

    ExpertsMapper mapper = new ExpertsMapperImpl();

    @Test
    @DisplayName("")
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
    @DisplayName("")
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

    @Test
    @DisplayName("")
    void expertToExpertDTONestedEntities() {
        // given
        Lecture lecture = Lecture.builder()
                .name("TAK")
                .build();

        Expert expert = Expert.builder()
                .lectures(Collections.singletonList(lecture))
                .build();

        // when
        ExpertDTO returnDTO = mapper.expertToExpertDTO(expert);

        // then
        assertEquals(lecture.getName(), returnDTO.getLecturesDTO().get(0).getName());
    }

    @Test
    @DisplayName("")
    void expertDTOToExpertNestedEntites() {
        // given
        LectureDTO lectureDTO = LectureDTO.builder()
                .price(9.99)
                .build();

        ExpertDTO expertDTO = ExpertDTO.builder()
                .lecturesDTO(Collections.singletonList(lectureDTO))
                .build();

        // when
        Expert returnObj = mapper.expertDTOToExpert(expertDTO);

        // then
        assertEquals(lectureDTO.getPrice(), returnObj.getLectures().get(0).getPrice(), 0.001);
    }

}

package pl.pjatk.projekt.mapstruct.courses;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.pjatk.projekt.dto.courses.ExpertDTO;
import pl.pjatk.projekt.dto.courses.LectureDTO;
import pl.pjatk.projekt.enums.Category;
import pl.pjatk.projekt.model.courses.Expert;
import pl.pjatk.projekt.model.courses.Lecture;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LecturesMapperTest {

    LecturesMapper mapper = new LecturesMapperImpl();

    @Test
    @DisplayName("")
    void lectureToLectureDTO() {
        // given
        Lecture lecture = Lecture.builder()
                .numberOfLectures(13)
                .build();

        // when
        LectureDTO returnDTO = mapper.lectureToLectureDto(lecture);

        // then
        assertEquals(lecture.getNumberOfLectures(), returnDTO.getNumberOfLectures());
    }

    @Test
    @DisplayName("")
    void lectureDTOToLecture() {
        // given
        LectureDTO lectureDTO = LectureDTO.builder()
                .category(Category.EDUCATION)
                .build();

        // when
        Lecture returnObj = mapper.lectureDTOToLecture(lectureDTO);

        // then
        assertEquals(lectureDTO.getCategory(), returnObj.getCategory());
    }

    @Test
    @DisplayName("")
    void lectureToLectureDTONestedEntities() {
        // given
        Expert expert = Expert.builder()
                .firstName("Janusz")
                .build();

        Lecture lecture = Lecture.builder()
                .expert(expert)
                .build();

        // when
        LectureDTO returnObj = mapper.lectureToLectureDto(lecture);

        // then
        assertEquals(lecture.getExpert().getFirstName(), returnObj.getExpertDTO().getFirstName());
    }

    @Test
    @DisplayName("")
    void lectureDTOToLectureNestedEntities() {
        // given
        ExpertDTO expertDTO = ExpertDTO.builder()
                .firstName("Aleksandra")
                .build();

        LectureDTO lectureDTO = LectureDTO.builder()
                .expertDTO(expertDTO)
                .build();

        // when
        Lecture returnObj = mapper.lectureDTOToLecture(lectureDTO);

        // then
        assertEquals(lectureDTO.getExpertDTO().getFirstName(), returnObj.getExpert().getFirstName());
    }
}

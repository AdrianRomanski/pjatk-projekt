package pl.pjatk.projekt.mapstruct.courses;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.pjatk.projekt.dto.courses.LectureDTO;
import pl.pjatk.projekt.enums.Category;
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
}

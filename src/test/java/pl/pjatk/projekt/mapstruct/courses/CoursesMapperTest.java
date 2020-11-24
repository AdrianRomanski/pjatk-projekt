package pl.pjatk.projekt.mapstruct.courses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.pjatk.projekt.dto.courses.CourseDTO;
import pl.pjatk.projekt.dto.courses.LectureDTO;
import pl.pjatk.projekt.enums.Category;
import pl.pjatk.projekt.model.courses.Course;
import pl.pjatk.projekt.model.courses.Lecture;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoursesMapperTest {

    CoursesMapper mapper = new CoursesMapperImpl();

    @Test
    @DisplayName("")
    void courseDTOtoCourse() {
        //given
        Course course = Course.builder()
                .name("Test")
                .build();

        //when
        CourseDTO returnDTO = mapper.courseToCourseDTO(course);

        //then
        assertEquals(course.getName(), returnDTO.getName());
    }

    @Test
    @DisplayName("")
    void courseToCourseDTO() {
        //given
        CourseDTO courseDTO = CourseDTO.builder()
                .name("Test")
                .build();

        //when
        Course returnObj = mapper.courseDTOtoCourse(courseDTO);

        //then
        assertEquals(courseDTO.getName(), returnObj.getName());
    }

    @Test
    @DisplayName("")
    void courseDTOToCourseNestedEntities() {
        // given
        LectureDTO lectureDTO = LectureDTO.builder()
                .category(Category.ELECTRONICS)
                .build();

        CourseDTO courseDTO = CourseDTO.builder()
                .lecturesDTO(Collections.singletonList(lectureDTO))
                .build();

        // when
        Course returnObj = mapper.courseDTOtoCourse(courseDTO);

        // then
        assertEquals(lectureDTO.getCategory(), returnObj.getLectures().get(0).getCategory());
    }

    @Test
    @DisplayName("")
    void courseToCourseDTONestedEntites() {
        // given
        Lecture lecture = Lecture.builder()
                .availableDuringCovid(true)
                .build();

        Course course = Course.builder()
                .lectures(Collections.singletonList(lecture))
                .build();

        // when
        CourseDTO returnDTO = mapper.courseToCourseDTO(course);

        // then
        assertEquals(lecture.getAvailableDuringCovid(), returnDTO.getLecturesDTO().get(0).getAvailableDuringCovid());
    }
}
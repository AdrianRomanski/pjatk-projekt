package pl.pjatk.projekt.mapstruct.courses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.pjatk.projekt.dto.courses.CourseDTO;
import pl.pjatk.projekt.model.courses.Course;

import static org.junit.jupiter.api.Assertions.*;

class CoursesMapperTest {

    CoursesMapper mapper = new CoursesMapperImpl();


    @Test
    @DisplayName("")
    void courseDTOtoCourse() {
        //given
        Course course = Course.builder().name("Test").build();
        //when

        CourseDTO returnDTO = mapper.courseToCourseDTO(course);
        //then
        Assertions.assertEquals(course.getName(), returnDTO.getName());
    }

    @Test
    @DisplayName("")
    void courseToCourseDTO() {
        //given
        CourseDTO courseDTO = CourseDTO.builder().name("Test").build();
        //when

        Course returnObj = mapper.courseDTOtoCourse(courseDTO);
        //then
        Assertions.assertEquals(courseDTO.getName(), returnObj.getName());
    }
}
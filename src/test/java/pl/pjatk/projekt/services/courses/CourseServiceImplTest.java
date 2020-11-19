package pl.pjatk.projekt.services.courses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.pjatk.projekt.dto.courses.CourseDTO;
import pl.pjatk.projekt.model.courses.Course;
import pl.pjatk.projekt.repositories.courses.CourseRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CourseServiceImplTest {

    @Mock
    CourseRepository courseRepository;

    @InjectMocks
    CourseServiceImpl courseService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Disabled
    @DisplayName("Should Return List of Courses")
    void getCourses(){
        // given
        List<Course> courses = Arrays.asList(new Course(), new Course());

        // when
        when(courseRepository.findAll()).thenReturn(courses);
        List<CourseDTO> returnObj = courseService.getCoursesDTO();

        // then
        assertEquals(returnObj.size(), 2);
    }
}

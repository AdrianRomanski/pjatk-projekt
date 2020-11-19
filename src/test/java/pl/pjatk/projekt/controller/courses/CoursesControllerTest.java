package pl.pjatk.projekt.controller.courses;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.pjatk.projekt.dto.courses.CourseDTO;
import pl.pjatk.projekt.dto.courses.LectureDTO;
import pl.pjatk.projekt.enums.Category;
import pl.pjatk.projekt.model.courses.Course;
import pl.pjatk.projekt.services.courses.CourseServiceImpl;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static pl.pjatk.projekt.controller.AbstractRestControllerTest.asJsonString;

public class CoursesControllerTest {

    @Mock
    CourseServiceImpl courseService;

    @InjectMocks
    CoursesController coursesController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(coursesController).build();
    }

    @Test
    @DisplayName("Should return list of courses")
    void getCourses() throws Exception{
        LectureDTO lectureDTO = LectureDTO.builder().name("test").build();

        // given
        var course = CourseDTO.builder()
                .category(Category.HOBBY)
                .name("TAK")
                .price(9.99)
                .lecturesDTO(singletonList(lectureDTO))
                .build();


        List<CourseDTO> courseDTO = List.of(course, new CourseDTO());

        // when
        when(courseService.getCoursesDTO()).thenReturn(courseDTO);

        // then
        mockMvc.perform(get("/api/courses")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(courseDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].name", equalTo("TAK")))
                .andExpect(jsonPath("$.[0].price", equalTo(9.99)))
                .andExpect(jsonPath("$.[0].lecturesDTO", hasSize(1)))
                .andExpect(jsonPath("$", hasSize(2)));
    }
}

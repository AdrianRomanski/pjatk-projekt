package pl.pjatk.projekt.controller.courses;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.pjatk.projekt.model.courses.Expert;
import pl.pjatk.projekt.model.courses.Lecture;
import pl.pjatk.projekt.services.courses.LectureServiceImpl;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static pl.pjatk.projekt.controller.AbstractRestControllerTest.asJsonString;

public class LecturesControllerTest {

    @Mock
    LectureServiceImpl lectureService;

    @InjectMocks
    LecturesController lecturesController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(lecturesController).build();
    }

    @Test
    @DisplayName("Should return list of Lectures")
    void getLectures() throws Exception{
        // given
        Lecture lecture = Lecture.builder()
                .availableDuringCovid(true)
                .numberOfLectures(10)
                .subject("Introduction")
                .build();

        List<Lecture> lectures = List.of(lecture, new Lecture(), new Lecture());

        // when
        when(lectureService.getLectures()).thenReturn(lectures);

        // then
        mockMvc.perform(get("/api/lectures")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(lectures)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].availableDuringCovid", equalTo(true)))
                .andExpect(jsonPath("$.[0].numberOfLectures", equalTo(10)))
                .andExpect(jsonPath("$.[0].subject", equalTo("Introduction")))
                .andExpect(jsonPath("$.[1].subject", equalTo(null)))
                .andExpect(jsonPath("$", hasSize(3)));

    }

    @Disabled("not sure how to check properties of inner field")
    @Test
    @DisplayName("Should return list of Lectures with Expert field properties")
    void getLecturesWithExpert() throws Exception{
        // given
        Expert expert = Expert.builder()
                .firstName("Janusz")
                .lastName("Tracz")
                .ageOfBirth(LocalDate.of(1990, 1, 1))
                .specialization("JSon")
                .build();

        Lecture lecture = Lecture.builder()
                .expert(expert)
                .availableDuringCovid(true)
                .numberOfLectures(10)
                .subject("Introduction")
                .build();

        List<Lecture> lectures = List.of(lecture, new Lecture(), new Lecture());

        // when
        when(lectureService.getLectures()).thenReturn(lectures);

        // then
        mockMvc.perform(get("/api/lectures")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(lectures)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].expert", equalTo(asJsonString(expert))))
                .andExpect(jsonPath("$.[0].expert", equalTo("Janusz")))
                .andExpect(jsonPath("$.[0].expert[*]", hasSize(4)));

    }
}

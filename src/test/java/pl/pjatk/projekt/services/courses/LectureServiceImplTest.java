package pl.pjatk.projekt.services.courses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.pjatk.projekt.model.courses.Lecture;
import pl.pjatk.projekt.repositories.courses.LectureRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class LectureServiceImplTest {

    @Mock
    LectureRepository lectureRepository;

    @InjectMocks
    LectureServiceImpl lectureService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should Return List of Lectures")
    void getLectures(){
        // given
        List<Lecture> lectures = Arrays.asList(new Lecture(), new Lecture(), new Lecture(), new Lecture());

        // when
        when(lectureRepository.findAll()).thenReturn(lectures);
        List<Lecture> returnObj = lectureService.getLectures();

        // then
        assertEquals(returnObj.size(), 4);
    }
}

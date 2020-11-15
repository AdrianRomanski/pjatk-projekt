package pl.pjatk.projekt.services.events;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.pjatk.projekt.model.events.Expert;
import pl.pjatk.projekt.repositories.events.ExpertRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ExpertServiceImplTest {

    @Mock
    ExpertRepository expertRepository;

    @InjectMocks
    ExpertServiceImpl expertService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should Return List of Experts")
    void getExperts(){
        // given
        List<Expert> experts = Arrays.asList(new Expert(), new Expert(), new Expert());

        // when
        when(expertRepository.findAll()).thenReturn(experts);
        List<Expert> returnObj = expertService.getExperts();

        // then
        assertEquals(returnObj.size(), 3);
    }
}

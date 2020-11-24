package pl.pjatk.projekt.controller.courses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.pjatk.projekt.dto.courses.ExpertDTO;
import pl.pjatk.projekt.services.courses.ExpertServiceImpl;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static pl.pjatk.projekt.controller.AbstractRestControllerTest.asJsonString;

public class ExpertsControllerTest {

    @Mock
    ExpertServiceImpl expertService;

    @InjectMocks
    ExpertsController expertsController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(expertsController).build();
    }

    @Test
    @DisplayName("Should return list of Experts")
    void getExperts() throws Exception{
        // given
        ExpertDTO expertDTO = new ExpertDTO();
        expertDTO.setSpecialization("testSpecialization");

        List<ExpertDTO> expertsDTO = List.of(expertDTO, new ExpertDTO());

        // when
        when(expertService.getExpertsDTO()).thenReturn(expertsDTO);

        // then
        mockMvc.perform(get("/api/experts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(expertsDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].specialization",equalTo("testSpecialization")))
                .andExpect(jsonPath("$",hasSize(2)));
    }

}

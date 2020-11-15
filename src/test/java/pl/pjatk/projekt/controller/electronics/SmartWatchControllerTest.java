package pl.pjatk.projekt.controller.electronics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.pjatk.projekt.model.electronics.SmartWatch;
import pl.pjatk.projekt.services.electronics.SmartWatchServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static pl.pjatk.projekt.controller.AbstractRestControllerTest.asJsonString;

class SmartWatchControllerTest {


    @Mock
    SmartWatchServiceImpl smartWatchService;

    @InjectMocks
    SmartWatchController controller;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("Should Return a List of Watches")
    void getWatches() throws Exception {
        //given
        List<SmartWatch> smartWatches = Arrays.asList(new SmartWatch(), new SmartWatch(), new SmartWatch());
        //when
        when(smartWatchService.getSmartWatches()).thenReturn(smartWatches);
        //then

        mockMvc.perform(get("/api/smartwatch")
                .accept(MediaType.APPLICATION_JSON)
                .content(asJsonString(smartWatches)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }
}
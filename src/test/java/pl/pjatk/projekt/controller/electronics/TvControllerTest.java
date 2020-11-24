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
import pl.pjatk.projekt.model.electronics.Tv;
import pl.pjatk.projekt.services.electronics.TvService;
import pl.pjatk.projekt.services.electronics.TvServiceImpl;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static pl.pjatk.projekt.controller.AbstractRestControllerTest.asJsonString;
import static org.hamcrest.Matchers.hasSize;

class TvControllerTest {

    @Mock
    TvServiceImpl tvService;

    @InjectMocks
    TvController controller;

    MockMvc mockMvc;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("Should return a list of tvs")

    void getTvs() throws Exception {

        List<Tv> tvs = Arrays.asList(new Tv(), new Tv(), new Tv());

        when(tvService.getTvs()).thenReturn(tvs);

        mockMvc.perform(get("/api/tv")
                .accept(MediaType.APPLICATION_JSON)
                .content(asJsonString(tvs)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }
}
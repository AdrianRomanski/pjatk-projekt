package pl.pjatk.projekt.services.electronics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.pjatk.projekt.model.electronics.Tv;
import pl.pjatk.projekt.repositories.electronics.TvRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TvServiceImplTest {
    @Mock
    TvRepository tvRepository;

    @InjectMocks
    TvServiceImpl tvService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

    }

    @Test
    @DisplayName("Should return list of tv's")

    void getTvs() {

        List<Tv> tvs = Arrays.asList(new Tv(), new Tv(), new Tv());

        when(tvRepository.findAll()).thenReturn(tvs);

        List<Tv> returnObj = tvService.getTvs();

        assertEquals(returnObj.size(), 3);
    }


}
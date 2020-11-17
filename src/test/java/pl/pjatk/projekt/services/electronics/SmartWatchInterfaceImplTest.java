package pl.pjatk.projekt.services.electronics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.pjatk.projekt.model.electronics.SmartWatch;
import pl.pjatk.projekt.repositories.electronics.SmartWatchRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class SmartWatchInterfaceImplTest {

    @Mock
    SmartWatchRepository smartWatchRepository;

    @InjectMocks
    SmartWatchServiceImpl smartWatchService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should Return List of Smart Watches")
    void getSmartWatches() {
        //given
        List<SmartWatch> smartWatches = Arrays.asList(new SmartWatch(), new SmartWatch(), new SmartWatch());
        //when

        when(smartWatchRepository.findAll()).thenReturn(smartWatches);
        //then

        List<SmartWatch> returnObj = smartWatchService.getSmartWatches();

        assertEquals(returnObj.size(), 3);
    }
}
package pl.pjatk.projekt.services.electronics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.pjatk.projekt.model.electronics.Xbox;
import pl.pjatk.projekt.repositories.electronics.XboxRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class XboxInterfaceImplTest {
    @Mock
    XboxRepository xboxRepository;

    @InjectMocks
    XboxServiceImpl xboxService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should Display List of Xboxes")
    void getXboxes() {
        //given
        List<Xbox> Xboxes = Arrays.asList(new Xbox(), new Xbox(), new Xbox());

        //when
        when(xboxRepository.findAll()).thenReturn(Xboxes);

        //then
        List<Xbox> returnObj = xboxService.getXboxes();

        assertEquals(returnObj.size(), 3);
    }
}

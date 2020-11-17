package pl.pjatk.projekt.controller.electronics;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.projekt.model.electronics.SmartWatch;
import pl.pjatk.projekt.services.electronics.SmartWatchService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/smartwatch")
public class SmartWatchController {

    private final SmartWatchService smartWatchService;

    @GetMapping
    List<SmartWatch> getWatches() {
        return smartWatchService.getSmartWatches();
    }
}

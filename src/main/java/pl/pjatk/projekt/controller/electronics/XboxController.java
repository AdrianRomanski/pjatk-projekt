package pl.pjatk.projekt.controller.electronics;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.projekt.model.electronics.Xbox;
import pl.pjatk.projekt.services.electronics.XboxService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/xbox")

public class XboxController {

    private final XboxService xboxService;

    @GetMapping
    List<Xbox> getXboxes() {
      return  xboxService.getXboxes();
    }
}

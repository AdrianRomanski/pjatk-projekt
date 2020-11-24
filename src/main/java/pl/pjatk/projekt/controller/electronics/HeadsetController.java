package pl.pjatk.projekt.controller.electronics;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.projekt.model.electronics.Headset;
import pl.pjatk.projekt.services.electronics.HeadsetService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/headset")
public class HeadsetController {

    private final HeadsetService headsetService;

    @GetMapping
    List<Headset> getHeadsets() { return headsetService.getHeadsets(); }
}
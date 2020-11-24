package pl.pjatk.projekt.controller.electronics;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.projekt.model.electronics.Tv;
import pl.pjatk.projekt.services.electronics.TvService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/tv")

public class TvController {

    private final TvService tvService;

    @GetMapping
    List<Tv> getTvs(){
        return tvService.getTvs();

    }
}

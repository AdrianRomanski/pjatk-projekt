package pl.pjatk.projekt.controller.events;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.projekt.model.events.Expert;
import pl.pjatk.projekt.services.events.ExpertService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/experts")
public class ExpertsController {

    private final ExpertService expertService;

    @GetMapping
    List<Expert> getExperts(){
        return expertService.getExperts();
    }
}

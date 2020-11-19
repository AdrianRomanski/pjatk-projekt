package pl.pjatk.projekt.controller.courses;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.projekt.dto.courses.ExpertDTO;
import pl.pjatk.projekt.model.courses.Expert;
import pl.pjatk.projekt.services.courses.ExpertService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/experts")
public class ExpertsController {

    private final ExpertService expertService;

    @GetMapping
    List<ExpertDTO> getExpertsDTO(){
        return expertService.getExpertsDTO();
    }
}

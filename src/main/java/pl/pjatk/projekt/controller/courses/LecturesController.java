package pl.pjatk.projekt.controller.courses;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.projekt.dto.courses.LectureDTO;
import pl.pjatk.projekt.model.courses.Lecture;
import pl.pjatk.projekt.services.courses.LectureService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/lectures")
public class LecturesController {

    private final LectureService lectureService;

    @GetMapping()
    List<LectureDTO> getLectures() {
        return lectureService.getLecturesDTO();
    }
}

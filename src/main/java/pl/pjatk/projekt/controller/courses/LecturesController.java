package pl.pjatk.projekt.controller.courses;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.projekt.model.events.Lecture;
import pl.pjatk.projekt.services.events.LectureService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/lectures")
public class LecturesController {

    private final LectureService lectureService;

    @GetMapping()
    List<Lecture> getLectures() {
        return lectureService.getLectures();
    }
}

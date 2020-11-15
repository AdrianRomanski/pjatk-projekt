package pl.pjatk.projekt.controller.courses;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.projekt.model.events.Course;
import pl.pjatk.projekt.services.events.CourseService;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CoursesController {

    private final CourseService courseService;

    @GetMapping
    List<Course> getCourses(){
        return courseService.getCourses();
    }
}

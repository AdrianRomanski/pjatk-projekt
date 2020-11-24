package pl.pjatk.projekt.controller.courses;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.projekt.dto.courses.CourseDTO;
import pl.pjatk.projekt.services.courses.CourseService;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CoursesController {

    private final CourseService courseService;

    @GetMapping
    List<CourseDTO> getCourses(){
        return courseService.getCoursesDTO();
    }
}

package pl.pjatk.projekt.services.courses;

import pl.pjatk.projekt.dto.courses.CourseDTO;
import pl.pjatk.projekt.model.courses.Course;

import java.util.List;

public interface CourseService {

    List<CourseDTO> getCoursesDTO();
}

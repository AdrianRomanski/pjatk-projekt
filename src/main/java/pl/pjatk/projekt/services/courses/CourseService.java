package pl.pjatk.projekt.services.courses;

import pl.pjatk.projekt.dto.courses.CourseDTO;

import java.util.List;

public interface CourseService {

    List<CourseDTO> getCoursesDTO();
}

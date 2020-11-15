package pl.pjatk.projekt.services.events;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pjatk.projekt.model.events.Course;
import pl.pjatk.projekt.repositories.courses.CourseRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }
}

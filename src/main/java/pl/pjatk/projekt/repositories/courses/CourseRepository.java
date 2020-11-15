package pl.pjatk.projekt.repositories.courses;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.projekt.model.events.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

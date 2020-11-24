package pl.pjatk.projekt.repositories.courses;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.projekt.model.courses.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, Long> {


}

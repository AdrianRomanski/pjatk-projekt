package pl.pjatk.projekt.services.events;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pjatk.projekt.model.events.Lecture;
import pl.pjatk.projekt.repositories.courses.LectureRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class LectureServiceImpl implements LectureService{

    private final LectureRepository lectureRepository;

    @Override
    public List<Lecture> getLectures() {
        return lectureRepository.findAll();
    }
}

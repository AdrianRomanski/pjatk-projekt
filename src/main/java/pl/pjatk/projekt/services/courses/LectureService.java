package pl.pjatk.projekt.services.courses;

import pl.pjatk.projekt.dto.courses.LectureDTO;
import pl.pjatk.projekt.model.courses.Lecture;

import java.util.List;

public interface LectureService {

    List<LectureDTO> getLecturesDTO();
}

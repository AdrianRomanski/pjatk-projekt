package pl.pjatk.projekt.services.courses;

import pl.pjatk.projekt.dto.courses.LectureDTO;

import java.util.List;

public interface LectureService {

    List<LectureDTO> getLecturesDTO();
}

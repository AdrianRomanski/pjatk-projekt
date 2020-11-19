package pl.pjatk.projekt.services.courses;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pjatk.projekt.dto.courses.LectureDTO;
import pl.pjatk.projekt.mapstruct.courses.LecturesMapper;
import pl.pjatk.projekt.repositories.courses.LectureRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class LectureServiceImpl implements LectureService{

    private final LectureRepository lectureRepository;
    private final LecturesMapper mapper;

    @Override
    public List<LectureDTO> getLecturesDTO() {
        return lectureRepository.findAll()
                .stream()
                .map(mapper::lectureToLectureDto)
                .collect(toList());
    }
}

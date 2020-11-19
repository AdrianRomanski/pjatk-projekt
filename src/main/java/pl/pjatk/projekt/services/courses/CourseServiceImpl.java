package pl.pjatk.projekt.services.courses;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pjatk.projekt.dto.courses.CourseDTO;
import pl.pjatk.projekt.mapstruct.courses.CoursesMapper;
import pl.pjatk.projekt.repositories.courses.CourseRepository;

import java.util.List;

import static java.util.stream.Collectors.*;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;
    private final CoursesMapper mapper;

    @Override
    public List<CourseDTO> getCoursesDTO() {
        return courseRepository.findAll()
                .stream()
                .map(mapper::courseToCourseDTO)
                .collect(toList());
    }
}


package pl.pjatk.projekt.mapstruct.courses;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.pjatk.projekt.dto.courses.CourseDTO;
import pl.pjatk.projekt.model.courses.Course;

@Mapper
public interface CoursesMapper {

    CoursesMapper INSTANCE = Mappers.getMapper(CoursesMapper.class);


    @Mapping(target = "lectures", source = "lecturesDTO")
    Course courseDTOtoCourse(CourseDTO courseDTO);

    @Mapping(target = "lecturesDTO", source = "lectures")
    CourseDTO courseToCourseDTO(Course course);
}

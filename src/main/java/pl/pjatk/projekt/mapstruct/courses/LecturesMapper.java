package pl.pjatk.projekt.mapstruct.courses;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.pjatk.projekt.dto.courses.LectureDTO;
import pl.pjatk.projekt.model.courses.Lecture;

@Mapper
public interface LecturesMapper {

    @Mapping(target = "lectures", source = "lecturesDTO")
    Lecture lectureDTOToLecture(LectureDTO lectureDTO);

    @Mapping(target = "lecturesDTO", source = "lectures")
    LectureDTO lectureToLectureDto(Lecture lecture);
}

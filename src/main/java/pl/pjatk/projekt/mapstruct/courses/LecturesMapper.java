package pl.pjatk.projekt.mapstruct.courses;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.pjatk.projekt.dto.courses.LectureDTO;
import pl.pjatk.projekt.model.courses.Lecture;

@Mapper
public interface LecturesMapper {

    LecturesMapper INSTANCE = Mappers.getMapper(LecturesMapper.class);

    @Mapping(target = "expert", source = "expertDTO")
    Lecture lectureDTOToLecture(LectureDTO lectureDTO);

    @Mapping(target = "expertDTO", source = "expert")
    LectureDTO lectureToLectureDto(Lecture lecture);
}

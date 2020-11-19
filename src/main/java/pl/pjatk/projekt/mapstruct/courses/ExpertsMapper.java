package pl.pjatk.projekt.mapstruct.courses;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.pjatk.projekt.dto.courses.ExpertDTO;
import pl.pjatk.projekt.model.courses.Expert;

@Mapper
public interface ExpertsMapper {

    ExpertsMapper INSTANCE = Mappers.getMapper(ExpertsMapper.class);

    @Mapping(target = "lectures", source = "lecturesDTO")
    Expert expertDTOToExpert(ExpertDTO expertDTO);

    @Mapping(target = "lecturesDTO", source = "lectures")
    ExpertDTO expertToExpertDTO(Expert expert);

}

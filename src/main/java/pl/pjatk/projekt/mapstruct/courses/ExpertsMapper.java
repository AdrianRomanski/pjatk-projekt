package pl.pjatk.projekt.mapstruct.courses;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.pjatk.projekt.dto.courses.ExpertDTO;
import pl.pjatk.projekt.model.courses.Expert;

@Mapper
public interface ExpertsMapper {

    @Mapping(target = "expert", source = "expertDTO")
    Expert expertDTOToExpert(ExpertDTO expertDTO);

    @Mapping(target = "expertDTO", source = "expert")
    ExpertDTO expertToExpertDTO(Expert expert);

}

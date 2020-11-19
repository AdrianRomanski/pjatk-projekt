package pl.pjatk.projekt.services.courses;

import pl.pjatk.projekt.dto.courses.ExpertDTO;
import pl.pjatk.projekt.model.courses.Expert;

import java.util.List;

public interface ExpertService {

    List<ExpertDTO> getExpertsDTO();
}

package pl.pjatk.projekt.services.courses;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pjatk.projekt.dto.courses.ExpertDTO;
import pl.pjatk.projekt.mapstruct.courses.ExpertsMapper;
import pl.pjatk.projekt.repositories.courses.ExpertRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class ExpertServiceImpl implements ExpertService {

    private final ExpertRepository expertRepository;
    private final ExpertsMapper mapper;

    @Override
    public List<ExpertDTO> getExpertsDTO() {
        return expertRepository.findAll()
                .stream()
                .map(mapper::expertToExpertDTO)
                .collect(toList());
    }
}

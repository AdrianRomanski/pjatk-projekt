package pl.pjatk.projekt.services.courses;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pjatk.projekt.model.courses.Expert;
import pl.pjatk.projekt.repositories.courses.ExpertRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ExpertServiceImpl implements ExpertService {

    private final ExpertRepository expertRepository;

    @Override
    public List<Expert> getExperts() {
        return expertRepository.findAll();
    }
}
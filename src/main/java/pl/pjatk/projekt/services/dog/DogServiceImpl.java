package pl.pjatk.projekt.services.dog;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pjatk.projekt.model.animal.Dog;
import pl.pjatk.projekt.repositories.animal.DogRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DogServiceImpl implements DogService {

    private final DogRepository dogRepository;

    @Override
    public List<Dog> getDogs() {
        return dogRepository.findAll();
    }
}

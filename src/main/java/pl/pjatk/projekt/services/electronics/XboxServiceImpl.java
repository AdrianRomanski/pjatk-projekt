package pl.pjatk.projekt.services.electronics;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pjatk.projekt.model.electronics.Xbox;
import pl.pjatk.projekt.repositories.electronics.XboxRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class XboxServiceImpl implements XboxService {

    private final XboxRepository xboxRepository;

    @Override
    public List<Xbox> getXboxes() {
        return xboxRepository.findAll();
    }
}

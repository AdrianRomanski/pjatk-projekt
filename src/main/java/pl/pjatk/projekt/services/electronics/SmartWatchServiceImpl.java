package pl.pjatk.projekt.services.electronics;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pjatk.projekt.model.electronics.SmartWatch;
import pl.pjatk.projekt.repositories.electronics.SmartWatchRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SmartWatchServiceImpl implements SmartWatchService {

    private final SmartWatchRepository smartWatchRepository;

    @Override
    public List<SmartWatch> getSmartWatches() {
        return smartWatchRepository.findAll();
    }
}

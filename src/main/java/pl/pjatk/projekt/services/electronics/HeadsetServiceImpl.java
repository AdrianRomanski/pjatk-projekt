package pl.pjatk.projekt.services.electronics;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pjatk.projekt.model.electronics.Headset;
import pl.pjatk.projekt.repositories.electronics.HeadsetRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class HeadsetServiceImpl implements HeadsetService {

    private final HeadsetRepository headsetRepository;

    @Override
    public List<Headset> getHeadsets() { return headsetRepository.findAll(); }
}
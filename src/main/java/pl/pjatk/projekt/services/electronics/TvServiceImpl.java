package pl.pjatk.projekt.services.electronics;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pjatk.projekt.model.electronics.Tv;
import pl.pjatk.projekt.repositories.electronics.TvRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class TvServiceImpl implements TvService {

    private final TvRepository tvRepository;
    @Override
    public List<Tv> getTvs() {
        return tvRepository.findAll();
    }
}

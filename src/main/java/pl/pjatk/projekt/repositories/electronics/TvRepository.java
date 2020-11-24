package pl.pjatk.projekt.repositories.electronics;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.projekt.model.electronics.Tv;

public interface TvRepository extends JpaRepository<Tv, Long> {
}

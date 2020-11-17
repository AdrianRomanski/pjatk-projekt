package pl.pjatk.projekt.repositories.electronics;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.projekt.model.electronics.SmartWatch;

public interface SmartWatchRepository extends JpaRepository<SmartWatch, Long> {
}

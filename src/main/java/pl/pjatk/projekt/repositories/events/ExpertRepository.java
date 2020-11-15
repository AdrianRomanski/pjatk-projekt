package pl.pjatk.projekt.repositories.events;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.projekt.model.events.Expert;

public interface ExpertRepository extends JpaRepository<Expert, Long> {
}

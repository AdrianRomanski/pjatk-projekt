package pl.pjatk.projekt.repositories.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.projekt.model.animal.Dog;

public interface DogRepository extends JpaRepository<Dog, Long> {
}

package pl.pjatk.projekt.repositories.electronics;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.projekt.model.electronics.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}

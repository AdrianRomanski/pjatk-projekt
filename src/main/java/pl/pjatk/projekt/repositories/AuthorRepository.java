package pl.pjatk.projekt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.projekt.model.books.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}

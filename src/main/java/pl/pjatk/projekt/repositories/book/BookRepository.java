package pl.pjatk.projekt.repositories.book;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.projekt.model.books.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}

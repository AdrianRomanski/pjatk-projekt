package pl.pjatk.projekt.controller.book;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.projekt.model.books.Book;
import pl.pjatk.projekt.services.book.BookService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/books")
public class BooksController {

    private final BookService bookService;

    @GetMapping()
    List<Book> getBooks() {
        return bookService.getBooks();
    }
}

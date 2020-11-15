package pl.pjatk.projekt.controller.book;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.projekt.model.books.Author;
import pl.pjatk.projekt.repositories.book.AuthorRepository;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;

    @GetMapping()
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

}

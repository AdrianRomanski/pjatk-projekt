package pl.pjatk.projekt.services.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.pjatk.projekt.model.books.Book;
import pl.pjatk.projekt.repositories.book.BookRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BookServiceImplTest {


    @Mock // udawac, zaslepianie
    BookRepository bookRepository;

    @InjectMocks
    BookServiceImpl bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should Return List With Books")
    void getBooks() {
        //given
        List<Book> books = Arrays.asList(new Book(), new Book(), new Book());
        //when

        when(bookRepository.findAll()).thenReturn(books);

        List<Book> returnObj = bookService.getBooks();
        //then

        assertEquals(returnObj.size(), 3);
    }
}
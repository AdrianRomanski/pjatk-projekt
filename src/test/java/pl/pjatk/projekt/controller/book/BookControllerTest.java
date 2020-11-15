package pl.pjatk.projekt.controller.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.pjatk.projekt.model.books.Book;
import pl.pjatk.projekt.services.book.BookService;
import pl.pjatk.projekt.services.book.BookServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static pl.pjatk.projekt.controller.AbstractRestControllerTest.asJsonString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



class BookControllerTest {
    @Mock
    BookServiceImpl bookService;

    @InjectMocks
    BooksController booksController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(booksController).build();
    }

    @Test
    @DisplayName("Should Return a list of authors")
    void getBooks() throws Exception {
        //given
        Book book = new Book();
        book.setName("test");

        List<Book> books = Arrays.asList(book, new Book(), new Book());
        //when

        when(bookService.getBooks()).thenReturn(books);
        //then

        mockMvc.perform(get("/api/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(books)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].name",equalTo("test")))
                .andExpect(jsonPath("$",hasSize(3)));
    }
}
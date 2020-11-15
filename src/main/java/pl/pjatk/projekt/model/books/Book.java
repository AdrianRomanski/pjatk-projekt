package pl.pjatk.projekt.model.books;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import pl.pjatk.projekt.enums.BookType;
import pl.pjatk.projekt.enums.Category;
import pl.pjatk.projekt.model.product.Product;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book extends Product {

    private String isbn;
    private BookType bookType;

    @ManyToOne
    @JsonManagedReference
    private Author author;

    @Builder
    public Book(Double price, String name, Category category, String isbn, Author author, BookType bookType) {
        super(price, name, category);
        this.isbn = isbn;
        this.author = author;
        this.bookType = bookType;
    }
}

package pl.pjatk.projekt.model.books;

import lombok.*;
import pl.pjatk.projekt.model.product.Product;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book extends Product {

    private String name;
    private String isbn;

    @OneToOne
    private Author author;


}

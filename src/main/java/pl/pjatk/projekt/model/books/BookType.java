package pl.pjatk.projekt.model.books;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.pjatk.projekt.model.BaseEntity;
import pl.pjatk.projekt.model.books.Book;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BookType extends BaseEntity {

    private String name;


}

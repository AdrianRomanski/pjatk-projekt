package pl.pjatk.projekt.model.courses;

import lombok.*;
import pl.pjatk.projekt.enums.Category;
import pl.pjatk.projekt.model.product.Product;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course extends Product {

    @OneToMany
    private List<Lecture> lectures;

    @Builder
    public Course(Double price, String name, Category category, List<Lecture> lectures) {
        super(price, name, category);
        this.lectures = Objects.requireNonNullElseGet(lectures, ArrayList::new);
    }
}

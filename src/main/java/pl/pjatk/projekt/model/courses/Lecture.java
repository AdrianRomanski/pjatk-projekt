package pl.pjatk.projekt.model.courses;

import lombok.*;
import pl.pjatk.projekt.enums.Category;
import pl.pjatk.projekt.model.product.Product;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Lecture extends Product {

    private String subject;
    private int numberOfLectures;
    private Boolean availableDuringCovid;

    @ManyToOne(fetch = FetchType.EAGER)
    private Expert expert;

    @Builder
    public Lecture(Double price, String name, Category category, Expert expert, String subject, int numberOfLectures, Boolean availableDuringCovid) {
        super(price, name, category);
        this.expert = expert;
        this.subject = subject;
        this.numberOfLectures = numberOfLectures;
        this.availableDuringCovid = availableDuringCovid;
    }
}

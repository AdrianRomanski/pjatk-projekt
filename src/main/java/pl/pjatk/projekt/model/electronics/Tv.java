package pl.pjatk.projekt.model.electronics;

import lombok.*;
import pl.pjatk.projekt.enums.Category;
import pl.pjatk.projekt.model.product.Product;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Tv extends Product {

    private int screenSize;
    private String brand;

    @Builder
    public Tv(Double price, String name, Category category, int screenSize, String brand) {
        super(price, name, category);
        this.screenSize = screenSize;
        this.brand = brand;
    }
}

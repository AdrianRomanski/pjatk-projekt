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
public class Headset extends Product {

    private boolean wireless;
    private String brand;

    @Builder
    public Headset(Double price, String name, Category category, boolean wireless, String brand) {
        super(price, name, category);
        this.wireless = wireless;
        this.brand = brand;
    }
}
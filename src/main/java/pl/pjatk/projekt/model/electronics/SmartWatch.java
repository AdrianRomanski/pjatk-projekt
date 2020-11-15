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
public class SmartWatch extends Product {

    private String color;
    private Double batterPower;
    private String brand;

    @Builder
    public SmartWatch(Double price, String name, Category category, String color, Double batterPower, String brand) {
        super(price, name, category);
        this.color = color;
        this.batterPower = batterPower;
        this.brand = brand;
    }
}

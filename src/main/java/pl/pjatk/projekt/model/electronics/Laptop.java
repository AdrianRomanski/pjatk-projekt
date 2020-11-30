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

public class Laptop extends Product {

    private String brand;
    private String model;
    private double screenSize;
    private int RAM;

    @Builder
    public Laptop(Double price, String name, Category category, String brand, double screenSize, int RAM) {
        super(price, name, category);
        this.brand = brand;
        this.screenSize = screenSize;
        this.RAM = RAM;
    }
}

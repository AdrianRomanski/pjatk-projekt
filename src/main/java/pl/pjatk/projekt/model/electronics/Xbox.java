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
public class Xbox extends Product {

    private String color;
    private Integer DiscVolume;

@Builder
    public Xbox(Double price, String name, Category category, String color, Integer DiscVolume) {
        super(price, name, category);
        this.color = color;
        this.DiscVolume = DiscVolume;
    }
}

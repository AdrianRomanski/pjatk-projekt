package pl.pjatk.projekt.model.animal;

import lombok.*;
import pl.pjatk.projekt.model.product.Product;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Animal extends Product {

    private Boolean doesItFly;

}

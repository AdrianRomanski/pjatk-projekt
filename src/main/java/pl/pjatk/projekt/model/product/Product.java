package pl.pjatk.projekt.model.product;

import lombok.*;
import pl.pjatk.projekt.model.BaseEntity;
import pl.pjatk.projekt.model.Category;

import javax.persistence.ManyToOne;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity {

    private Double price;
    private String name;

    @ManyToOne
    private Category category;


}

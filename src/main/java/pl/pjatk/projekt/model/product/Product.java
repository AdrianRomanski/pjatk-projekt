package pl.pjatk.projekt.model.product;

import lombok.*;
import pl.pjatk.projekt.enums.Category;
import pl.pjatk.projekt.model.BaseEntity;

import javax.persistence.MappedSuperclass;

@Setter
@Getter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity {

    private Double price;
    private String name;
    private Category category;


}

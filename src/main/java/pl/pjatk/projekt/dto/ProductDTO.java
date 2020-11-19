package pl.pjatk.projekt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.pjatk.projekt.enums.Category;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO extends BaseEntityDTO{

    private Double price;
    private String name;
    private Category category;
}

package pl.pjatk.projekt.dto.courses;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.pjatk.projekt.dto.ProductDTO;
import pl.pjatk.projekt.enums.Category;
import pl.pjatk.projekt.model.product.Product;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
public class CourseDTO extends ProductDTO {

    private List<LectureDTO> lecturesDTO;

    @Builder
    public CourseDTO(Double price, String name, Category category, List<LectureDTO> lecturesDTO) {
        super(price, name, category);
        this.lecturesDTO = Objects.requireNonNullElseGet(lecturesDTO, ArrayList::new);
    }
}

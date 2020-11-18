package pl.pjatk.projekt.dto.courses;

import lombok.*;
import pl.pjatk.projekt.dto.ProductDTO;
import pl.pjatk.projekt.enums.Category;
import pl.pjatk.projekt.model.product.Product;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LectureDTO extends ProductDTO {

    private String subject;
    private int numberOfLectures;
    private Boolean availableDuringCovid;

    private ExpertDTO expertDTO;

    @Builder
    public LectureDTO(Double price, String name, Category category, ExpertDTO expertDTO, String subject, int numberOfLectures, Boolean availableDuringCovid) {
        super(price, name, category);
        this.expertDTO = expertDTO;
        this.subject = subject;
        this.numberOfLectures = numberOfLectures;
        this.availableDuringCovid = availableDuringCovid;
    }
}

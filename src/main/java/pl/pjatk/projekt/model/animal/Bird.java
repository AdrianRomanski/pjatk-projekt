package pl.pjatk.projekt.model.animal;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bird extends Animal {

    private String wingsType;
    private Double velocity;
    private String color;

}

package pl.pjatk.projekt.model.animal;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dog extends Animal {

    private String furType;
    private Double weight;
}

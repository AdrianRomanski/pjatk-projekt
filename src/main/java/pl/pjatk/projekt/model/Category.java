package pl.pjatk.projekt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;


@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntity{

    private String name;
}

package pl.pjatk.projekt.model.events;

import lombok.*;
import pl.pjatk.projekt.model.product.Product;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event extends Product {

    private LocalDate eventStarts;
    private LocalDate eventEnds;
}

package pl.pjatk.projekt.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.projekt.model.animal.Dog;
import pl.pjatk.projekt.model.product.Product;
import pl.pjatk.projekt.services.dog.DogService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/dogs")
public class DogsController {

    private final DogService dogService;

    @GetMapping("/dogs")
    private List<Dog> getDogs() {
        return dogService.getDogs();
    }

}

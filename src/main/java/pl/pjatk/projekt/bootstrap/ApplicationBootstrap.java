package pl.pjatk.projekt.bootstrap;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.pjatk.projekt.enums.BookType;
import pl.pjatk.projekt.enums.Category;
import pl.pjatk.projekt.model.books.Author;
import pl.pjatk.projekt.model.books.Book;
import pl.pjatk.projekt.model.electronics.*;
import pl.pjatk.projekt.model.courses.Course;
import pl.pjatk.projekt.model.courses.Expert;
import pl.pjatk.projekt.model.courses.Lecture;
import pl.pjatk.projekt.repositories.book.AuthorRepository;
import pl.pjatk.projekt.repositories.book.BookRepository;
import pl.pjatk.projekt.repositories.courses.CourseRepository;
import pl.pjatk.projekt.repositories.courses.ExpertRepository;
import pl.pjatk.projekt.repositories.courses.LectureRepository;
import pl.pjatk.projekt.repositories.electronics.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class ApplicationBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    // Book
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    // Courses
    private final ExpertRepository expertRepository;
    private final LectureRepository lectureRepository;
    private final CourseRepository courseRepository;
    // Electronics
    private final SmartWatchRepository smartWatchRepository;
    private final XboxRepository xboxRepository;
    private final TvRepository tvRepository;
    private final HeadsetRepository headsetRepository;
    private final LaptopRepository laptopRepository;

    @Override
    @SneakyThrows
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // Do not refactor to method - example OneToMany, ManyToOne
        Book book = Book.builder()
                .price(22.4)
                .name("Achaja")
                .bookType(BookType.FANTASY)
                .isbn("223-442-12-24412")
                .category(Category.HOBBY)
                .build();

        Book book2 = Book.builder()
                .price(22.4)
                .name("Achaja 2")
                .bookType(BookType.FANTASY)
                .isbn("223-442-12-24412")
                .category(Category.HOBBY)
                .build();

        Author author = Author.builder()
                .firstName("Andrzej")
                .lastName("Ziemiański")
                .ageOfBirth(LocalDate.of(1992,11,3))
                .books(Arrays.asList(book, book2))
                .build();

        book.setAuthor(author);
        book2.setAuthor(author);

        authorRepository.save(author);
        bookRepository.save(book);
        bookRepository.save(book2);

        //Do not refactor to method - example simple entity
        // Smart Watch
        SmartWatch smartWatch = SmartWatch.builder()
                .name("iWatch")
                .price(245.60)
                .category(Category.ELECTRONICS)
                .batterPower(12.4).color("Blue")
                .brand("Apple")
                .build();

        smartWatchRepository.save(smartWatch);

       //Xbox

        Xbox xbox = Xbox.builder()
                .name("Xbox One X")
                .price(150.20)
                .category(Category.ELECTRONICS)
                .color("Black")
                .DiscVolume(1024)
                .build();

        Xbox xbox1 = Xbox.builder()
                .name("Xbox One X")
                .price(150.20)
                .category(Category.ELECTRONICS)
                .color("White")
                .DiscVolume(1024)
                .build();

        Xbox xbox2 = Xbox.builder()
                .name("Xbox Series X")
                .category(Category.ELECTRONICS)
                .price(1050.30)
                .color("Black")
                .DiscVolume(1024)
                .build();

        Xbox xbox3 = Xbox.builder()
                .name("Xbox Series S")
                .category(Category.ELECTRONICS)
                .price(1050.30)
                .color("White")
                .DiscVolume(1024)
                .build();

        xboxRepository.save(xbox);
        xboxRepository.save(xbox1);
        xboxRepository.save(xbox2);
        xboxRepository.save(xbox3);

        //Tv

        Tv tv = Tv.builder()
                .name("OLED")
                .category(Category.ELECTRONICS)
                .price(2999.99)
                .brand("LG")
                .screenSize(50)
                .build();

        tvRepository.save(tv);

        //Headset

        Headset headset = Headset.builder()
                .name("QuietComfort 35 II")
                .category(Category.ELECTRONICS)
                .price(1199.99)
                .brand("BOSE")
                .wireless(true)
                .build();

        headsetRepository.save(headset);

        // Laptop

        Laptop laptop = Laptop.builder()
                .name("MacBook Pro")
                .category(Category.ELECTRONICS)
                .price(6199.99)
                .brand("Apple")
                .screenSize(15.0)
                .RAM(16)
                .build();

        laptopRepository.save(laptop);

        initCourses();
    }

    private void initCourses() {
        // COURSES
        Expert expert = Expert.builder()
                .firstName("Janusz")
                .lastName("Tracz")
                .ageOfBirth(LocalDate.of(1981, 11, 2))
                .specialization("Various")
                .build();

        Lecture lecture = Lecture.builder()
                .name("Lecture name")
                .category(Category.EDUCATION)
                .price(12.04)
                .expert(expert)
                .numberOfLectures(3)
                .availableDuringCovid(true)
                .subject("Wstęp")
                .build();

        Lecture lecture2 = Lecture.builder()
                .name("Lecture name")
                .category(Category.EDUCATION)
                .price(12.04)
                .expert(expert)
                .numberOfLectures(15)
                .availableDuringCovid(false)
                .subject("TAK")
                .build();

        expert.getLectures().addAll(Arrays.asList(lecture, lecture2));

        expertRepository.save(expert);
        lectureRepository.save(lecture);
        lectureRepository.save(lecture2);

        Course course = Course.builder()
                .price(12.05)
                .name("Java for Beginners")
                .category(Category.EDUCATION)
                .lectures(List.of(lecture, lecture2))
                .build();

        courseRepository.save(course);
    }
}

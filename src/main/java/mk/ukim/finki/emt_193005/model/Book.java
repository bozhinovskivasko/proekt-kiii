package mk.ukim.finki.emt_193005.model;

import lombok.Data;
import mk.ukim.finki.emt_193005.model.enumerations.Category;

import javax.persistence.*;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;

    @Enumerated(value = EnumType.STRING)
    Category category;

    @ManyToOne
    Author author;

    Integer availableCopies;

    public Book() {
    }

    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}

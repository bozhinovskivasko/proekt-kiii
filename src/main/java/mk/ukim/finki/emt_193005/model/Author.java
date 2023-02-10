package mk.ukim.finki.emt_193005.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;

    String surname;

    String fullName;

    @ManyToOne
    Country country;

    public Author() {
    }

    public Author(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.fullName = this.name + " " + this.surname;
    }
}

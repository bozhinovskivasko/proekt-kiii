package mk.ukim.finki.emt_193005.service;

import mk.ukim.finki.emt_193005.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Optional<Author> findById(Long id);

    List<Author> findAll();

    Optional<Author> save(String name, String surname, Long countryId);

    Optional<Author> edit(Long id, String name, String surname, Long countryId);

    void deleteById(Long id);
}

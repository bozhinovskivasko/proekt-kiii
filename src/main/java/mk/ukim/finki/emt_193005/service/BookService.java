package mk.ukim.finki.emt_193005.service;

import mk.ukim.finki.emt_193005.model.Book;
import mk.ukim.finki.emt_193005.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<Book> findById(Long id);

    List<Book> findAll();

    Optional<Book> save(String name, Category category, Long authorId, Integer availableCopies);

    Optional<Book> edit(Long id, String name, Category category, Long authorId, Integer availableCopies);

    void deleteById(Long id);

    Optional<Book> rented(Long id);
}

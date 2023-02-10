package mk.ukim.finki.emt_193005.service.impl;

import mk.ukim.finki.emt_193005.model.Author;
import mk.ukim.finki.emt_193005.model.Book;
import mk.ukim.finki.emt_193005.model.enumerations.Category;
import mk.ukim.finki.emt_193005.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emt_193005.model.exceptions.BookNotFoundException;
import mk.ukim.finki.emt_193005.repository.AuthorRepository;
import mk.ukim.finki.emt_193005.repository.BookRepository;
import mk.ukim.finki.emt_193005.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> save(String name, Category category, Long authorId, Integer availableCopies) {
        Author author = this.authorRepository
                .findById(authorId).orElseThrow(() -> new AuthorNotFoundException(authorId));

        Book book = this.bookRepository.save(new Book(name, category, author, availableCopies));

        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, String name, Category category, Long authorId, Integer availableCopies) {

        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        Author author = this.authorRepository
                .findById(authorId).orElseThrow(() -> new AuthorNotFoundException(authorId));

        book.setName(name);
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);

        this.bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> rented(Long id) {

        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        book.setAvailableCopies(book.getAvailableCopies() - 1);

        this.bookRepository.save(book);
        return Optional.of(book);
    }
}

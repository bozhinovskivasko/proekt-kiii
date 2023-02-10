package mk.ukim.finki.emt_193005.repository;

import mk.ukim.finki.emt_193005.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}

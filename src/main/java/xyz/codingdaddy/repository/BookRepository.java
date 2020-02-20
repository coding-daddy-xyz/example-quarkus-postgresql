package xyz.codingdaddy.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import xyz.codingdaddy.domain.Book;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

/**
 * Provides access to book objects stored in database
 *
 * @author serhiy
 */
@ApplicationScoped
public class BookRepository implements PanacheRepository<Book> {
    public Optional<Book> findByIsbn(String isbn) {
        return Optional.ofNullable(find("isbn", isbn).firstResult());
    }
}

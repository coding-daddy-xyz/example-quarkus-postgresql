package xyz.codingdaddy.domain;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Book entity
 *
 * @author serhiy
 */
@Data
@RegisterForReflection
@Entity
public class Book {
    @Id
    private String isbn;
    private String name;
    private String author;
}

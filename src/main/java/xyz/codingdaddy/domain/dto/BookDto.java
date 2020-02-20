package xyz.codingdaddy.domain.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

/**
 * Data transfer object for book entity
 *
 * @author serhiy
 */
@Data
@RegisterForReflection
public class BookDto {
    private String isbn;
    private String name;
    private String author;
}

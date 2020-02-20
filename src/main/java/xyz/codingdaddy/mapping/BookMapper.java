package xyz.codingdaddy.mapping;

import org.mapstruct.Mapper;
import xyz.codingdaddy.config.MappingConfig;
import xyz.codingdaddy.domain.Book;
import xyz.codingdaddy.domain.dto.BookDto;

/**
 * Performs mapping between {@link Book} entity and respective data transfer object {@link BookDto}
 *
 * @author serhiy
 */
@Mapper(config = MappingConfig.class)
public interface BookMapper {
    /**
     * Maps {@link Book} entity to {@link BookDto}
     *
     * @param book entity to be mapped
     * @return mapped dto
     */
    BookDto toResource(Book book);

    /**
     * Maps {@link BookDto} to {@link Book} entity
     *
     * @param bookDto to be mapped
     * @return mapped entity
     */
    Book fromResource(BookDto bookDto);
}
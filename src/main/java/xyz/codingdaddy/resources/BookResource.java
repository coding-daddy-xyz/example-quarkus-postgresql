package xyz.codingdaddy.resources;

import xyz.codingdaddy.domain.Book;
import xyz.codingdaddy.domain.dto.BookDto;
import xyz.codingdaddy.mapping.BookMapper;
import xyz.codingdaddy.repository.BookRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.util.stream.Collectors;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

/**
 * Endpoint for {@link Book}-related functionality
 *
 * @author serhiy
 */
@Path("/books")
@Produces("application/json")
@Consumes("application/json")
public class BookResource {
    @Inject
    BookRepository bookRepository;
    @Inject
    BookMapper bookMapper;

    @GET
    @Path("/{isbn}")
    public Response find(@PathParam("isbn") String isbn) {
        return bookRepository.findByIsbn(isbn)
                .map(b -> Response.ok(bookMapper.toResource(b)))
                .orElseGet(() -> Response.status(NOT_FOUND))
                .build();
    }

    @GET
    public Response findAll() {
        return Response.ok(bookRepository.findAll().stream().map(b -> bookMapper.toResource(b)).collect(Collectors.toList())).build();
    }

    @POST
    public Response create(BookDto bookDto) {
        Book book = bookMapper.fromResource(bookDto);
        bookRepository.persist(book);
        return Response.ok(book).build();
    }

    @DELETE
    @Path("/{isbn}")
    public Response delete(@PathParam("isbn") String isbn) {
        return bookRepository.findByIsbn(isbn)
                .map(b -> { bookRepository.delete(b); return Response.ok(); })
                .orElseGet(() -> Response.status(NOT_FOUND))
                .build();
    }
}

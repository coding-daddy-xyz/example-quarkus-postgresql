package xyz.codingdaddy.resources;

import xyz.codingdaddy.domain.User;
import xyz.codingdaddy.domain.dto.UserDto;
import xyz.codingdaddy.mapping.UserMapper;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.util.stream.Collectors;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

/**
 * Endpoint for {@link User}-related functionality
 *
 * @author serhiy
 */
@Path("/users")
@Produces("application/json")
@Consumes("application/json")
public class UserResource {
    @Inject
    UserMapper userMapper;

    @GET
    @Path("/{username}")
    public Response find(@PathParam("username") String username) {
        return User.findByUsername(username)
                .map(u -> Response.ok(userMapper.toResource(u)))
                .orElseGet(() -> Response.status(NOT_FOUND))
                .build();
    }

    @GET
    public Response findAll() {
        return Response.ok(User.<User>findAll().stream().map(u -> userMapper.toResource(u)).collect(Collectors.toList())).build();
    }

    @Transactional
    @POST
    public Response create(UserDto userDto) {
        User user = userMapper.fromResource(userDto);
        user.persistAndFlush();
        return Response.ok(userMapper.toResource(user)).build();
    }

    @DELETE
    @Path("/{username}")
    public Response delete(@PathParam("username") String username) {
        return User.findByUsername(username)
                .map(u -> { u.delete(); return Response.ok(); })
                .orElseGet(() -> Response.status(NOT_FOUND))
                .build();
    }
}

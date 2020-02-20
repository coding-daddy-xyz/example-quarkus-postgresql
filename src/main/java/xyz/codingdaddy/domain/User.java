package xyz.codingdaddy.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Optional;

/**
 * User entity which provides access to user objects in database
 *
 * @author serhiy
 */
@Data
@RegisterForReflection
@Entity(name="users")
public class User extends PanacheEntity {
    private String username;
    private String password;
    private String email;

    public static Optional<User> findByUsername(String username) {
        return Optional.ofNullable(find("username", username).firstResult());
    }
}

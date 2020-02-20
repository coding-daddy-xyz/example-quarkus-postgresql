package xyz.codingdaddy.mapping;

import org.mapstruct.Mapper;
import xyz.codingdaddy.config.MappingConfig;
import xyz.codingdaddy.domain.User;
import xyz.codingdaddy.domain.dto.UserDto;

/**
 * Performs mapping between {@link User} entity and respective data transfer object {@link UserDto}
 *
 * @author serhiy
 */
@Mapper(config = MappingConfig.class)
public interface UserMapper {
    /**
     * Maps {@link User} entity to {@link UserDto}
     *
     * @param user to be mapped
     * @return mapped dto
     */
    UserDto toResource(User user);

    /**
     * Maps {@link UserDto} to {@link User} entity
     *
     * @param userDto to be mapped
     * @return mapped entity
     */
    User fromResource(UserDto userDto);
}
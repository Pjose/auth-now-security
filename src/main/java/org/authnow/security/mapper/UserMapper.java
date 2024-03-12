package org.authnow.security.mapper;

import org.authnow.security.dto.UserDTO;
import org.authnow.security.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping( target = "password", ignore = true)
    @Mapping( target = "tokens", ignore = true)
    @Mapping( target = "oAuthKey", source = "OAuthKey")
    User toUser(UserDTO userDto);

    @Mapping( target = "oAuthKey", source = "OAuthKey")
    UserDTO toUserDTO(User user);
    
}

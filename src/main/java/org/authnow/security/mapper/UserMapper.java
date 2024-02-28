package org.authnow.security.mapper;

import org.authnow.security.dto.UserDTO;
import org.authnow.security.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping( target = "password", ignore = true)
    User userDtoToUser(UserDTO userDto);
    
}

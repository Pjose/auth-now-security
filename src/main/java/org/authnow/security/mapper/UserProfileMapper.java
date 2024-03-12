package org.authnow.security.mapper;

import org.authnow.security.dto.UserProfileDTO;
import org.authnow.security.model.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {

    UserProfileMapper INSTANCE = Mappers.getMapper(UserProfileMapper.class);

    UserProfile toUserProfile(UserProfileDTO userProfileDto);

    UserProfileDTO toUserProfileDTO(UserProfile userProfile);

}

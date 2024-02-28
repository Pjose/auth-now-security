package org.authnow.security.dto;

import java.util.List;

import org.authnow.security.model.Role;
import org.authnow.security.model.Token;
import org.authnow.security.model.UserProfile;

public record UserDTO(
    Long id,
    UserProfile userProfile,
    String email,
    boolean hasDrive,
    String activeSubscription,
    String userHistory,
    String oAuthKey,
    String driveAccessKey,
    Role role,
    List<Token> tokens
) {
    
}

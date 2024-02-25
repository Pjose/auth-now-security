package org.authnow.security.dto;

import java.util.List;

import org.authnow.security.model.Role;
import org.authnow.security.model.Token;
import org.authnow.security.model.UserProfile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private UserProfile userProfile;
    private String email;
    private String password;
    private boolean hasDrive;
    private String activeSubscription;
    private String userHistory;
    private String oAuthKey;
    private String driveAccessKey;
    private Role role;
    private List<Token> tokens;
    
}

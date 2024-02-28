package org.authnow.security.dto;

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
    private Long id;
    private UserProfile userProfile;
    private String email;
    private boolean hasDrive;
    private String activeSubscription;
    private String userHistory;
    private String oAuthKey;
    private String driveAccessKey;
    private String role;
}

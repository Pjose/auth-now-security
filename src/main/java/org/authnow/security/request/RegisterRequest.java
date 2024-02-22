package org.authnow.security.request;

import org.authnow.security.model.Role;
import org.authnow.security.model.UserProfile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private UserProfile userProfile;
    private String email;
    private String password;
    private Role role;

}

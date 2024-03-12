package org.authnow.security.service;

import org.authnow.security.dto.UserProfileDTO;
import org.authnow.security.request.ChangePasswordRequest;

import java.security.Principal;

public interface UserService {

    void changePassword(ChangePasswordRequest request, Principal connectedUser);
    UserProfileDTO getUserProfile(Principal principal);
}

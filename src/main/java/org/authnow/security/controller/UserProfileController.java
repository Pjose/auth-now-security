package org.authnow.security.controller;

import java.security.Principal;

import org.authnow.security.dto.UserProfileDTO;
import org.authnow.security.service.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user-profile")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<UserProfileDTO> getUserProfile(Principal principal) {
        return ResponseEntity.ok(userService.getUserProfile(principal));
    }
    
}

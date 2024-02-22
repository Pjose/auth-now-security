package org.authnow.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user-profile")
public class UserProfileController {

    @GetMapping
    public ResponseEntity<String> getUserProfile() {
        return ResponseEntity.ok("User profile from secured endpoint");
    }
    
}

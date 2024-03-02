package org.authnow.security.service;

import java.io.IOException;

import org.authnow.security.request.AuthenticationRequest;
import org.authnow.security.request.RegisterRequest;
import org.authnow.security.response.AuthenticationResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
    void refreshToken(HttpServletRequest request, HttpServletResponse response
        ) throws IOException;
}

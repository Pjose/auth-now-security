package org.authnow.security.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.authnow.security.model.Patient;
import org.authnow.security.model.Role;
import org.authnow.security.model.UserProfile;
import org.authnow.security.request.RegisterRequest;
import org.authnow.security.response.AuthenticationResponse;
import org.authnow.security.service.AuthenticationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
public class AuthenticationControllerTest {

    //Unit Tests for login and JWT auth

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @MockBean
    private AuthenticationServiceImpl service;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
          .webAppContextSetup(context)
          .apply(SecurityMockMvcConfigurers.springSecurity())
          .build();
    }

    @Test
    void should_register_new_user_and_succeed_with_200() throws Exception {
        //given
        Set<String> medicalEvents = new HashSet<>();
        medicalEvents.add("Full ckeck-up");
        Patient patient = new Patient(1L, "Alice Noname", medicalEvents, "Peanut allergy");
        Set<Patient> patients = new HashSet<>();
        patients.add(patient);
        Date dob = new SimpleDateFormat("yyyy-mm-dd").parse("1975-09-23");
        UserProfile userProfile = new UserProfile(1L, "jane_doe@email.com", "555-654-3210", dob, "Operating Theater 1", patients);
        //User user = new User(101L, userProfile, "jane_doe@email.com", "12345", false, "", "", "", "", Role.ADMIN, )
        RegisterRequest registerRequest = new RegisterRequest(userProfile, "jane_doe@email.com", "12345", Role.ADMIN);
        
        AuthenticationResponse authResponse = new AuthenticationResponse();
        Mockito.when(service.register(registerRequest)).thenReturn(authResponse);

        //TODO:
        //when

        //then

        
    }

}

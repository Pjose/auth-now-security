package org.authnow.security.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.authnow.security.dto.UserProfileDTO;
import org.authnow.security.model.Patient;
import org.authnow.security.service.UserServiceImpl;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserProfileControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
          .webAppContextSetup(context)
          .apply(SecurityMockMvcConfigurers.springSecurity())
          .build();
    }

    @MockBean
    private UserServiceImpl userService;

    @WithMockUser(value = "spring")
    @Test
    void given_auth_request_getUserProfile_should_succeed_with_200() throws Exception {
        //given
        var principal = new Principal() {
            @Override
            public String getName() { return "jane_doe@email.com";}
        };
        Set<String> medicalEvents = new HashSet<>();
        medicalEvents.add("Full ckeck-up");
        Patient patient = new Patient(1L, "Alice Noname", medicalEvents, "Peanut allergy");
        Set<Patient> patients = new HashSet<>();
        patients.add(patient);
        Date dob = new SimpleDateFormat("yyyy-mm-dd").parse("1975-09-23");
        UserProfileDTO userProfileDto = new UserProfileDTO(1L, "jane_doe@email.com", "555-654-3210", dob, "Operating Theater 1", patients);
        
        Mockito.when(userService.getUserProfile(principal)).thenReturn(userProfileDto);
        
        //when
        MvcResult mvcResult = mockMvc.perform(get("/api/v1/user-profile")).andReturn();

        //then
        assertEquals(200, mvcResult.getResponse().getStatus());
    }

}

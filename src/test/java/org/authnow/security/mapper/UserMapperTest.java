package org.authnow.security.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.authnow.security.dto.UserDTO;
import org.authnow.security.model.Patient;
import org.authnow.security.model.Role;
import org.authnow.security.model.Token;
import org.authnow.security.model.User;
import org.authnow.security.model.UserProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserMapperTest {

    Long id;
    String name, phone, email, password, activeSubscription, userHistory, oAuthKey, driveAccessKey, 
        role, workspace, patientProfile;
    boolean hasDrive;
    DateFormat dateFormat;
    Date dob;
    Set<String> medicalEvents;
    Patient patient_1;
    Set<Patient> patients;
    List<Token> tokens;

    @BeforeEach
    void setUp() throws ParseException {
        id = 101L;
        email = "john_doe@email.com";
        hasDrive = true;
        activeSubscription = "Has active subscription stub";
        userHistory = "Has a user history stub";
        oAuthKey = "$ecret_0auth_key";
        driveAccessKey = "drive_@cess_key";
        role = "ADMIN";

        name = "John Doe";
        phone = "987-654-3210";
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dob = dateFormat.parse("1986-05-28");
        workspace = "Operating Theater 3";
        patientProfile = "Dummy patient profile";

        medicalEvents = new HashSet<>();
        medicalEvents.add("Recieved Flu shot on 2/3/2023");
        medicalEvents.add("Had COVID-19 on 12/30/2023");
        
        patients = new HashSet<>();
        patient_1 = new Patient(1L, name, medicalEvents, patientProfile);
        patients.add(patient_1);

        tokens = new ArrayList<>();

    }

    @Test
    void shouldMapUserDTO_toUser() {

        //given
        UserProfile userProfile = new UserProfile(id, name, phone, dob, workspace, patients);
        UserDTO userDto = new UserDTO(id, userProfile, email, hasDrive, activeSubscription, userHistory, oAuthKey, driveAccessKey, role);

        //when
        User user = UserMapper.INSTANCE.toUser(userDto);

        //then
        assertNotNull(user);
        assertEquals(id, user.getId());
        assertEquals(userProfile, user.getUserProfile());
        assertEquals(email, user.getEmail());
        assertEquals(hasDrive, user.isHasDrive());
        assertEquals(activeSubscription, user.getActiveSubscription());
        assertEquals(userHistory, user.getUserHistory());
        assertEquals(oAuthKey, user.getOAuthKey());
        assertEquals(driveAccessKey, user.getDriveAccessKey());
        
    }

    @Test
    void should_map_userDTO_to_user_when_userDTO_is_null() {
        //given
        UserDTO userDto = null;

        //when
        User user = UserMapper.INSTANCE.toUser(userDto);

        //then
        assertNull(user);

    }

    @Test
    void shouldMapUser_toUserDTO() {

        //given
        UserProfile userProfile = new UserProfile(id, name, phone, dob, workspace, patients);
        User user = new User(id, userProfile, email, password, hasDrive, activeSubscription, userHistory, oAuthKey, driveAccessKey, Role.ADMIN, tokens);

        //when
        UserDTO userDTO = UserMapper.INSTANCE.toUserDTO(user);

        //then
        assertNotNull(userDTO);
        assertEquals(id, userDTO.getId());
        assertEquals(userProfile, userDTO.getUserProfile());
        assertEquals(email, userDTO.getEmail());
        assertEquals(hasDrive, userDTO.isHasDrive());
        assertEquals(activeSubscription, userDTO.getActiveSubscription());
        assertEquals(userHistory, userDTO.getUserHistory());
        assertEquals(oAuthKey, userDTO.getOAuthKey());
        assertEquals(driveAccessKey, userDTO.getDriveAccessKey());
        assertEquals(Role.ADMIN.name(), userDTO.getRole());
        
    }

}

package org.authnow.security.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.authnow.security.dto.UserDTO;
import org.authnow.security.model.Patient;
import org.authnow.security.model.User;
import org.authnow.security.model.UserProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserMapperTest {

    UserDTO userDto;
    UserProfile userProfile;
    Patient patient;

    Long id;
    String name, phone, email, activeSubscription, userHistory, oAuthKey, driveAccessKey, 
        role, workspace, patientProfile;
    boolean hasDrive;
    DateFormat dateFormat;
    Date dob;
    Set<String> medicalEvents;
    Patient patient_1;
    Set<Patient> patients;

    @BeforeEach
    void initializeObjectsBeforeEachTest() throws ParseException {
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

        userProfile = null;
        userDto = null;
    }

    @Test
    void shouldMapUserDtoToUser() {

        //given
        userProfile = new UserProfile(id, name, phone, dob, workspace, patients);
        userDto = new UserDTO(id, userProfile, email, hasDrive, activeSubscription, userHistory, oAuthKey, driveAccessKey, role);

        //when
        User user = UserMapper.INSTANCE.userDtoToUser(userDto);

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

}

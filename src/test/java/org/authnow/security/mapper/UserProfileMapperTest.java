package org.authnow.security.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.authnow.security.dto.UserProfileDTO;
import org.authnow.security.model.Patient;
import org.authnow.security.model.UserProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserProfileMapperTest {

    UserProfile userProfile;
    Patient patient;

    Long id;
    String name, phone, workspace, patientProfile;
    boolean hasDrive;
    DateFormat dateFormat;
    Date dob;
    Set<String> medicalEvents;
    Set<Patient> patients;

    @BeforeEach
    void initializeObjectsBeforeEachTest() throws ParseException {
        id = 1L;
        name = "John Doe";
        phone = "987-654-3210";
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dob = dateFormat.parse("1989-01-08");
        workspace = "Operating Theater 3";
        patientProfile = "Dummy patient profile";

        medicalEvents = new HashSet<>();
        patients = new HashSet<>();
    }

    @Test
    void shouldMapUserProfileDtoToUserProfile() {

        //given
        medicalEvents.add("Recieved Flu shot on 2/3/2023");
        medicalEvents.add("Had COVID-19 on 12/30/2023");
        patient = new Patient(1L, name, medicalEvents, patientProfile);

        patients.add(patient);

        UserProfileDTO userProfileDto = new UserProfileDTO(id, name, phone, dob, workspace, patients);

        //when
        UserProfile userProfile = UserProfileMapper.INSTANCE.userProfileDtoToUserProfile(userProfileDto);
       
        //then
        assertNotNull(userProfile);
        assertEquals(id, userProfile.getId());
        assertEquals(name, userProfile.getName());
        assertEquals(phone, userProfile.getPhone());
        assertEquals(dob, userProfile.getDob());
        assertEquals(workspace, userProfile.getWorkspace());
        assertEquals(patients, userProfile.getPatients());
    }

}

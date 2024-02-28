package org.authnow.security.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.doubleThat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.authnow.security.dto.UserProfileDTO;
import org.authnow.security.model.Patient;
import org.authnow.security.model.UserProfile;
import org.junit.jupiter.api.Test;

class UserProfileMapperTest {

    @Test
    void shouldMapUserProfileDtoToUserProfile() throws ParseException {
/*Long id,
    String name,
    String phone,
    Date dob,
    String workspace,
    Set<Patient> patients */
        //given
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dob = dateFormat.parse("1989-01-08");
        String name = "John Doe";
        String phone = "987-654-3210";
        String workspace = "Operating Theater 3";
        Set<String> medicalEvents = new HashSet<>();
        medicalEvents.add("Recieved Flu shot on 2/3/2023");
        medicalEvents.add("Had COVID-19 on 12/30/2023");
        String patientProfile = "Dummy patient profile";
        Patient patient_1 = new Patient(1L, name, medicalEvents, patientProfile);
        Set<Patient> patients = new HashSet<>();
        patients.add(patient_1);
        UserProfileDTO userProfileDto = new UserProfileDTO(1L, name, phone, dob, workspace, patients);

        //when
        UserProfile userProfile = UserProfileMapper.INSTANCE.userProfileDtoToUserProfile(userProfileDto);
       
        //then
        assertNotNull(userProfile);
        assertEquals(1L, userProfile.getId());
        assertEquals(name, userProfile.getName());
        assertEquals(phone, userProfile.getPhone());
        assertEquals(dob, userProfile.getDob());
        assertEquals(workspace, userProfile.getWorkspace());
        assertEquals(patients, userProfile.getPatients());
    }

}

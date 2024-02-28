package org.authnow.security.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.authnow.security.dto.PatientDTO;
import org.authnow.security.model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PatientMapperTest {

    PatientDTO patientDto;

    Long id;
    String name, patientProfile;
    Set<String> medicalEvents;

    @BeforeEach
    void initializeVariablesBeforeEach() {
        id = 1L;
        name = "John Doe";
        patientProfile = "Dummy patient profile";
        medicalEvents = new HashSet<>();
    }

    @Test
    void shouldMapPatientDtoToPatient() {
        
        //given
        medicalEvents.add("Recieved Flu shot on 2/3/2023");
        medicalEvents.add("Had COVID-19 on 12/30/2023");

        patientDto = new PatientDTO(id, name, medicalEvents, patientProfile);

        //when
        Patient patient = PatientMapper.INSTANCE.patientDtoToPatient(patientDto);
    
        //then
        assertNotNull(patient);
        assertEquals(id, patient.getId());
        assertEquals(name, patient.getName());
        assertEquals(medicalEvents, patient.getMedicalEvents());
        assertEquals(patientProfile, patient.getPatientProfile());
    }
}

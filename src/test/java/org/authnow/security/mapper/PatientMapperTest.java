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

    Long id;
    String name, patientProfile;
    Set<String> medicalEvents;

    @BeforeEach
    void setUp() {
        id = 1L;
        name = "John Doe";
        patientProfile = "Dummy patient profile";
        medicalEvents = new HashSet<>();
    }

    @Test
    void shouldMapPatientDTO_toPatient() {
        
        //given
        medicalEvents.add("Recieved Flu shot on 2/3/2023");
        medicalEvents.add("Had COVID-19 on 12/30/2023");

        PatientDTO patientDto = new PatientDTO(id, name, medicalEvents, patientProfile);

        //when
        Patient patient = PatientMapper.INSTANCE.toPatient(patientDto);
    
        //then
        assertNotNull(patient);
        assertEquals(id, patient.getId());
        assertEquals(name, patient.getName());
        assertEquals(medicalEvents, patient.getMedicalEvents());
        assertEquals(patientProfile, patient.getPatientProfile());
    }

    @Test
    void shouldMapPatient_toPatientDTO() {

        //given
        medicalEvents.add("Recieved Flu shot on 2/3/2023");
        medicalEvents.add("Had COVID-19 on 12/30/2023");

        Patient patient = new Patient(id, name, medicalEvents, patientProfile);

        //when
        PatientDTO patientDTO = PatientMapper.INSTANCE.toPatientDTO(patient);
    
        //then
        assertNotNull(patientDTO);
        assertEquals(id, patientDTO.getId());
        assertEquals(name, patientDTO.getName());
        assertEquals(medicalEvents, patientDTO.getMedicalEvents());
        assertEquals(patientProfile, patientDTO.getPatientProfile());
    }
}

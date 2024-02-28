package org.authnow.security.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.authnow.security.dto.PatientDTO;
import org.authnow.security.model.Patient;
import org.junit.jupiter.api.Test;

class PatientMapperTest {

    @Test
    void shouldMapPatientDtoToPatient() {
        
        //given
        Set<String> medicalEvents = new HashSet<>();
        medicalEvents.add("Recieved Flu shot on 2/3/2023");
        medicalEvents.add("Had COVID-19 on 12/30/2023");
        PatientDTO patientDto = new PatientDTO(1L, "John Doe", medicalEvents, "Dummy patient profile"  );
    
        //when
        Patient patient = PatientMapper.INSTANCE.patientDtoToPatient(patientDto);
    
        //then
        assertNotNull(patient);
        assertEquals(1L, patient.getId());
        assertEquals("John Doe", patient.getName());
        assertEquals(medicalEvents, patient.getMedicalEvents());
        assertEquals("Dummy patient profile", patient.getPatientProfile());
    }
}

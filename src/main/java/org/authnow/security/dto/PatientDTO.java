package org.authnow.security.dto;

import java.util.Set;

public record PatientDTO(
    Long id,
    String name,
    Set<String> medicalEvents,
    String patientProfile
) {

}

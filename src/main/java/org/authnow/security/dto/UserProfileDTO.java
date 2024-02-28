package org.authnow.security.dto;

import java.util.Date;
import java.util.Set;

import org.authnow.security.model.Patient;

public record UserProfileDTO(
    Long id,
    String name,
    String phone,
    Date dob,
    String workspace,
    Set<Patient> patients
) {

}

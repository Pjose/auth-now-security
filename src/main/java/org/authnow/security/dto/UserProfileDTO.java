package org.authnow.security.dto;

import java.util.Date;
import java.util.Set;

import org.authnow.security.model.Patient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileDTO {

    private String name;
    private String phone;
    private Date dob;
    private String workspace;
    private Set<Patient> patients;

}

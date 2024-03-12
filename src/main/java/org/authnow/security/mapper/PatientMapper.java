package org.authnow.security.mapper;

import org.authnow.security.dto.PatientDTO;
import org.authnow.security.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    Patient toPatient(PatientDTO patientDTO);

    PatientDTO toPatientDTO(Patient patient);

}

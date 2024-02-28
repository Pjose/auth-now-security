package org.authnow.security.mapper;

import org.authnow.security.dto.PatientDTO;
import org.authnow.security.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    Patient patientDtoToPatient(PatientDTO patientDTO);

}

package com.jpacourse.mapper;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;

import java.util.List;
import java.util.stream.Collectors;

public final class PatientMapper {

    // Maps PatientEntity to PatientTO
    public static PatientTO mapToTO(final PatientEntity patientEntity) {
        if (patientEntity == null) {
            return null;
        }
        final PatientTO patientTO = new PatientTO();
        patientTO.setId(patientEntity.getId());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setDiabetes(patientEntity.getDiabetes());
        patientTO.setVisits(patientEntity.getVisits().stream()
                .map(PatientMapper::mapVisitToTO)
                .collect(Collectors.toList()));
        return patientTO;
    }

    // Helper method to map a list of VisitEntity to a list of VisitTO
    private static VisitTO mapVisitToTO(VisitEntity visit) {
        if (visit == null) {
            return null;
        }
        VisitTO visitTO = new VisitTO();
        visitTO.setVisitTime(visit.getTime());
        visitTO.setDoctorName(visit.getDoctor().getFirstName() + " " + visit.getDoctor().getLastName());
        visitTO.setTreatmentTypes(
                visit.getMedicalTreatments().stream()
                        .map(treatment -> treatment.getType().getDisplayName()) // Using custom method for descriptive name
                        .collect(Collectors.toList())
        );
        return visitTO;
    }

    // Maps PatientTO back to PatientEntity (simplified, focusing on visit mapping)
    public static PatientEntity mapToEntity(final PatientTO patientTO) {
        if (patientTO == null) {
            return null;
        }
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientTO.getId());
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setDateOfBirth(patientTO.getDateOfBirth());
        patientEntity.setPatientNumber(patientTO.getPatientNumber());
        patientEntity.setDiabetes(patientTO.getDiabetes());
        // Visits are complex to map back and typically handled in a service layer.
        return patientEntity;
    }
}
package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;

import java.time.LocalDateTime;

public interface PatientService {
    PatientTO getPatientById(Long id);

    void deletePatient(Long patientId);

    PatientTO addPatient(PatientTO patientTO);

    void addVisitToPatient(Long patientId, Long doctorId, LocalDateTime visitDate, String description);
}

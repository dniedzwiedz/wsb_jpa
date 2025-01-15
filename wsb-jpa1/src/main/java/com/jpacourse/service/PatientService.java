package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;

import java.time.LocalDateTime;
import java.util.List;

public interface PatientService {
    PatientTO getPatientById(Long id);

    void deletePatient(Long patientId);

    PatientTO addPatient(PatientTO patientTO);

    void addVisitToPatient(Long patientId, Long doctorId, LocalDateTime visitDate, String description);

    List<VisitTO> findVisitsByPatientId(Long id);
}

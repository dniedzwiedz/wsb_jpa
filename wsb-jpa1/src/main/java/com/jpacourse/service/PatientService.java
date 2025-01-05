package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import java.time.LocalDateTime;

public interface PatientService {
    /**
     * Finds a patient by their ID.
     * @param id The ID of the patient.
     * @return The Transfer Object representing the patient, or null if not found.
     */
    PatientTO getPatientById(Long id);

    /**
     * Deletes a patient and all their associated visits, ensuring no doctors are deleted.
     * @param patientId The ID of the patient to delete.
     */
    void deletePatient(Long patientId);

    /**
     * Adds a visit to a patient's record.
     * @param patientId The ID of the patient.
     * @param doctorId The ID of the doctor.
     * @param visitDate The date and time of the visit.
     * @param description A description of the visit.
     */
    void addVisitToPatient(Long patientId, Long doctorId, LocalDateTime visitDate, String description);

    /**
     * Adds a patient based on the given Transfer Object.
     * @param patientTO The Transfer Object containing the patient data.
     * @return The newly added PatientTO with ID set.
     */
    PatientTO addPatient(PatientTO patientTO);
}
package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.PatientEntity;

import java.time.LocalDateTime;
import java.util.List;

import com.jpacourse.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDao extends Dao<PatientEntity, Long> {
    List<PatientEntity> findByLastName(String lastName);
    void addVisitToPatient(Long patientId, Long doctorId, LocalDateTime visitDate, String description);
    List<VisitEntity> findVisitsByPatientId(Long patientId);
    List<PatientEntity> findPatientsWithVisitsMoreThan(Integer number);
    List<PatientEntity> findPatientWithDiabetes(Boolean isDiabetes);
}
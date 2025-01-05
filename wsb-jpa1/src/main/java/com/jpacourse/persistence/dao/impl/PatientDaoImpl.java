package com.jpacourse.persistence.dao.impl;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addVisitToPatient(Long patientId, Long doctorId, LocalDateTime visitTime, String description) {
        PatientEntity patient = findOne(patientId);
        DoctorEntity doctor = entityManager.find(DoctorEntity.class, doctorId);
        if (patient != null && doctor != null) {
            VisitEntity visit = new VisitEntity();
            visit.setDoctor(doctor);
            visit.setTime(visitTime);
            visit.setDescription(description);
            visit.setPatient(patient);
            patient.getVisits().add(visit);
            update(patient);
        }
    }
}

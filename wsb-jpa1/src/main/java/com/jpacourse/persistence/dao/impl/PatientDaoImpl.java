package com.jpacourse.persistence.dao.impl;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PatientEntity> findByLastName(String lastName) {
        return entityManager.createQuery("SELECT patients FROM PatientEntity patients WHERE lastName = :lastName",
                PatientEntity.class).setParameter("lastName", lastName).getResultList();
    }

    @Override
    public List<VisitEntity> findVisitsByPatientId(Long id) {
        return entityManager.createQuery("SELECT visit FROM VisitEntity visit WHERE visit.patient.id = :id",
                VisitEntity.class).setParameter("id", id).getResultList();
    }

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

    @Override
    public List<PatientEntity> findPatientsWithVisitsMoreThan(Integer number) {
        return entityManager.createQuery("SELECT patients FROM PatientEntity patients JOIN patients.visits visits GROUP BY patients HAVING CAST(COUNT(visits) AS int) > :number",
                PatientEntity.class).setParameter("number", number).getResultList();
    }

    @Override
    public List<PatientEntity> findPatientWithDiabetes(Boolean isDiabetes) {
        return entityManager.createQuery("SELECT patients FROM PatientEntity patients WHERE patients.diabetes = :isDiabetes",
                PatientEntity.class).setParameter("isDiabetes", isDiabetes).getResultList();
    }
}

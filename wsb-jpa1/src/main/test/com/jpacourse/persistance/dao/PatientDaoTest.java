package com.jpacourse.persistance.dao;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.dao.DoctorDao;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private DoctorDao doctorDao;

    @Test
    @Transactional
    public void testAddVisitToPatient() {
        Long patientId = 1L;
        Long doctorId = 1L;
        LocalDateTime visitTime = LocalDateTime.now();
        String description = "New Visit Description";
        patientDao.addVisitToPatient(patientId, doctorId, visitTime, description);
        PatientEntity patient = patientDao.findOne(patientId);
        assertThat(patient).isNotNull();
        assertThat(patient.getVisits()).isNotEmpty();
        VisitEntity visit = patient.getVisits().get(patient.getVisits().size() - 1);
        assertThat(visit.getDescription()).isEqualTo(description);
        assertThat(visit.getTime()).isEqualTo(visitTime);
        assertThat(visit.getDoctor().getId()).isEqualTo(doctorId);
    }

    @Test
    @Transactional
    public void testFindPatientsByLastName() {
        String lastName = "Klauza";
        List<PatientEntity> patients = patientDao.findByLastName(lastName);
        assertThat(patients).isNotEmpty();
        assertThat(patients.get(0).getLastName()).isEqualTo(lastName);
    }

    @Test
    @Transactional
    public void findPatientsWithMoreThanXVisits() {
        Integer numberOfVisits = 0;
        List<PatientEntity> patients = patientDao.findPatientsWithVisitsMoreThan(numberOfVisits);
        assertThat(patients).isNotEmpty();
        patients.forEach(patient ->
                assertThat(patient.getVisits().size()).isGreaterThan(numberOfVisits));
    }

    @Test
    @Transactional
    public void findPatientsWithDiabetes() {
        Boolean isDiabetes = true;
        List<PatientEntity> patients = patientDao.findPatientWithDiabetes(isDiabetes);
        assertThat(patients).isNotEmpty();
        patients.forEach(patient ->
                assertThat(patient.getDiabetes()).isTrue());
    }
}
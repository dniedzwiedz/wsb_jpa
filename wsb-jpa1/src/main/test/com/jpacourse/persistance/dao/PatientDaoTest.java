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
        // given
        Long patientId = 1L;
        Long doctorId = 1L;
        LocalDateTime visitTime = LocalDateTime.now();
        String description = "New Visit Description";

        // when
        patientDao.addVisitToPatient(patientId, doctorId, visitTime, description);

        // then
        PatientEntity patient = patientDao.findOne(patientId);
        assertThat(patient).isNotNull();
        assertThat(patient.getVisits()).isNotEmpty();
        VisitEntity visit = patient.getVisits().get(patient.getVisits().size() - 1);
        assertThat(visit.getDescription()).isEqualTo(description);
        assertThat(visit.getTime()).isEqualTo(visitTime);
        assertThat(visit.getDoctor().getId()).isEqualTo(doctorId);
    }
}
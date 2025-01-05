package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistence.dao.DoctorDao;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.service.impl.PatientServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientServiceImpl patientService;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private DoctorDao doctorDao;

    @Test
    @Transactional
    public void testDeletePatientShouldCascadeDeleteVisitsAndNotDeleteDoctors() {
        // given
        Long patientId = 1L;
        Long doctorId = 1L;

        // Retrieve existing doctor and patient
        DoctorEntity doctor = doctorDao.findOne(doctorId);
        PatientEntity patient = patientDao.findOne(patientId);

        // Ensure the patient has visits
        assertThat(patient.getVisits()).isNotEmpty();

        // when
        patientService.deletePatient(patient.getId());

        // then
        assertThat(patientDao.findOne(patient.getId())).isNull();
        assertThat(doctorDao.findOne(doctor.getId())).isNotNull();
    }

    @Test
    @Transactional
    public void testGetPatientByIdShouldReturnCorrectStructure() {
        // given
        Long patientId = 1L;

        // Retrieve existing patient
        PatientEntity patient = patientDao.findOne(patientId);

        // when
        PatientTO patientTO = patientService.getPatientById(patient.getId());

        // then
        assertThat(patientTO).isNotNull();
        assertThat(patientTO.getId()).isEqualTo(patient.getId());
        assertThat(patientTO.getFirstName()).isEqualTo(patient.getFirstName());
        assertThat(patientTO.getLastName()).isEqualTo(patient.getLastName());
        assertThat(patientTO.getTelephoneNumber()).isEqualTo(patient.getTelephoneNumber());
        assertThat(patientTO.getEmail()).isEqualTo(patient.getEmail());
        assertThat(patientTO.getPatientNumber()).isEqualTo(patient.getPatientNumber());
        assertThat(patientTO.getDateOfBirth()).isEqualTo(patient.getDateOfBirth());
        assertThat(patientTO.getDiabetes()).isEqualTo(patient.getDiabetes());
    }
}
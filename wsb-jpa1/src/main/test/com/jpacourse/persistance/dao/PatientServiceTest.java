package com.jpacourse.persistance.dao;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.enums.TreatmentType;
//import com.jpacourse.service.DoctorService;
import com.jpacourse.service.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest {
    @Autowired
    private PatientService patientService;
    //@Autowired
    //private VisitService visitService;
    //@Autowired
    //private DoctorService doctorService;
    //remove patient with id 1 from data.sql
    @Test
    public void removePatientCascadeTest() {
        Long patientId = 1L;
        Long visitId = 1L;
        Long doctorId = 1L;
        var patientBeforeDeletion = patientService.getPatientById(patientId);
        assertThat(patientBeforeDeletion).isNotNull();
        patientService.deletePatient(patientId);
       // var visit = visitService.findById(visitId);
      //  assertThat(visit).isNull();
       // var doctor = doctorService.findById(doctorId);
       // assertThat(doctor).isNotNull();
    }
    @Test
    public void findPatientByIdShouldReturnCorrectTO() {
        Long patientId = 1L;
        PatientTO patientTO = patientService.getPatientById(patientId);
        assertThat(patientTO).isNotNull();
        assertThat(patientTO.getId()).isEqualTo(patientId);
        assertThat(patientTO.getFirstName()).isEqualTo("Dawid");
        assertThat(patientTO.getLastName()).isEqualTo("Niedzwiedz");
        assertThat(patientTO.getPatientNumber()).isEqualTo("c123");
        assertThat(patientTO.getDateOfBirth()).isEqualTo(LocalDate.of(2000, 1, 1));
        //assertThat(patientTO.getDiabetes()).isEqualTo(diabetes.False);
        assertThat(patientTO.getVisits()).isNotNull().isNotEmpty();
        assertThat(patientTO.getVisits().size()).isEqualTo(1);
        VisitTO visitTO = patientTO.getVisits().get(0);
        //assertThat(visitTO.getDescription()).isEqualTo("Checkup appointment");
        //assertThat(visitTO.getTime()).isEqualTo(LocalDateTime.of(2024, 12, 5, 9, 30));
        //assertThat(visitTO.getDoctorFirstName()).isEqualTo("John");
        //assertThat(visitTO.getDoctorLastName()).isEqualTo("Doe");
        //assertThat(visitTO.getTreatmentTypes()).containsExactly(TreatmentType.PHYSICAL);
    }
}
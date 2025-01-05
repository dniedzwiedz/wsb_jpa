package com.jpacourse.rest;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.rest.exception.EntityNotFoundException;
import com.jpacourse.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/{id}")
    public PatientTO getPatientById(@PathVariable Long id) {
        PatientTO patient = patientService.getPatientById(id);
        if (patient == null) {
            throw new EntityNotFoundException(id);
        }
        return patient;
    }

    @PostMapping
    public PatientTO addPatient(@RequestBody PatientTO patientTO) {
        return patientService.addPatient(patientTO);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
}

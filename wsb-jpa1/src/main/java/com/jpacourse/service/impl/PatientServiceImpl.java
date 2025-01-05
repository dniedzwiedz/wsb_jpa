package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.PatientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDao patientDao;

    @Override
    public PatientTO getPatientById(Long id) {
        Optional<PatientEntity> patientOptional = patientDao.findById(id);
        return patientOptional.map(this::mapToPatientTO).orElse(null);
    }

    @Override
    @Transactional
    public void deletePatient(Long patientId) {
        patientDao.deleteById(patientId);
    }

    @Override
    @Transactional
    public void addVisitToPatient(Long patientId, Long doctorId, LocalDateTime visitDate, String description) {
        Optional<PatientEntity> patientOpt = patientDao.findById(patientId);
        // Assuming DoctorDao and logic for fetching doctor entity
        if (patientOpt.isPresent()) {
            PatientEntity patient = patientOpt.get();
            // Logic to create the visit and add it to the patient
        }
    }

    @Override
    @Transactional
    public PatientTO addPatient(PatientTO patientTO) {
        PatientEntity patientEntity = mapToPatientEntity(patientTO);
        patientEntity = patientDao.save(patientEntity);
        return mapToPatientTO(patientEntity);
    }

    private PatientTO mapToPatientTO(PatientEntity patient) {
        PatientTO dto = new PatientTO();
        dto.setId(patient.getId());
        dto.setFirstName(patient.getFirstName());
        dto.setLastName(patient.getLastName());
        dto.setDateOfBirth(patient.getDateOfBirth());
        dto.setPatientNumber(patient.getPatientNumber());
        dto.setDiabetes(patient.getDiabetes());
        // Map visits if necessary
        return dto;
    }

    private PatientEntity mapToPatientEntity(PatientTO dto) {
        PatientEntity patient = new PatientEntity();
        patient.setFirstName(dto.getFirstName());
        patient.setLastName(dto.getLastName());
        patient.setDateOfBirth(dto.getDateOfBirth());
        patient.setPatientNumber(dto.getPatientNumber());
        patient.setDiabetes(dto.getDiabetes());
        // Map additional fields as necessary
        return patient;
    }
}
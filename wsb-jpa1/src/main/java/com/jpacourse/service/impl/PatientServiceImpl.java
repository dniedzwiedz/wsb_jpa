package com.jpacourse.service.impl;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDao patientDao;

    @Override
    public PatientTO getPatientById(Long id) {
        PatientEntity patient = patientDao.findOne(id);
        return PatientMapper.mapToTO(patient);
    }

    @Override
    @Transactional
    public void deletePatient(Long patientId) {
        patientDao.delete(patientId);
    }

    @Override
    @Transactional
    public PatientTO addPatient(PatientTO patientTO) {
        PatientEntity patientEntity = PatientMapper.mapToEntity(patientTO);
        patientEntity = patientDao.save(patientEntity);
        return PatientMapper.mapToTO(patientEntity);
    }

    @Override
    @Transactional
    public void addVisitToPatient(Long patientId, Long doctorId, LocalDateTime visitDate, String description) {
        patientDao.addVisitToPatient(patientId, doctorId, visitDate, description);
    }
}
package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDao extends JpaRepository<PatientEntity, Long> {
    // You can add custom query methods here if needed
}
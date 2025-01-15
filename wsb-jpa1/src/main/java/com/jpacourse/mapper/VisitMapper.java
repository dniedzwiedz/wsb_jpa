package com.jpacourse.mapper;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistence.entity.MedicalTreatmentEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.enums.TreatmentType;

import java.util.List;
import java.util.stream.Collectors;

public final class VisitMapper {
    private VisitMapper() {}

    public static VisitTO mapToTO(VisitEntity visitEntity) {
        if (visitEntity == null) {
            return null;
        }
        VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setTime(visitEntity.getTime());

        List<String> medicalTreatmentTypes = visitEntity.getMedicalTreatments().stream()
                .map(MedicalTreatmentEntity::getType)
                .map(TreatmentType::name)
                .collect(Collectors.toList());
        visitTO.setTreatmentTypes(medicalTreatmentTypes);
        return visitTO;
    }

    public static List<VisitTO> mapToTOs(List<VisitEntity> visits) {
        return visits.stream()
                .map(VisitMapper::mapToTO)
                .collect(Collectors.toList());
    }
}
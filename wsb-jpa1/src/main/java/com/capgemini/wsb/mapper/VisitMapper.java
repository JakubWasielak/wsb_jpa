package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import java.util.List;
import java.util.stream.Collectors;

public final class VisitMapper {
    public static VisitTO mapToTO(final VisitEntity visitEntity) {
        if (visitEntity == null) {
            return null;
        }

        final VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setTime(visitEntity.getTime());
        visitTO.setPatient(visitEntity.getPatient());
        visitTO.setDoctor(visitEntity.getDoctor());
        visitTO.setMedicalTreatments(visitEntity.getMedicalTreatments());
        return visitTO;

    }

    public static VisitEntity mapToEntity(final VisitTO visitTO) {
        if (visitTO == null) {
            return null;
        }

        final VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(visitTO.getId());
        visitEntity.setDescription(visitTO.getDescription());
        visitEntity.setTime(visitTO.getTime());
        visitEntity.setPatient(visitTO.getPatient());
        visitEntity.setDoctor(visitTO.getDoctor());
        visitEntity.setMedicalTreatments(visitEntity.getMedicalTreatments());
        return visitEntity;
    }

    public static List<VisitTO> mapToTOList(final List<VisitEntity> visitEntities) {
        return visitEntities.stream()
            .map(VisitMapper::mapToTO)
            .collect(Collectors.toList());
    }
}

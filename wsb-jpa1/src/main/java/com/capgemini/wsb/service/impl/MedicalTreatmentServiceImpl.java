package com.capgemini.wsb.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.wsb.dto.MedicalTreatmentTO;
import com.capgemini.wsb.mapper.MedicalTreatmentMapper;
import com.capgemini.wsb.persistence.dao.MedicalTreatmentDao;
import com.capgemini.wsb.persistence.entity.MedicalTreatmentEntity;
import com.capgemini.wsb.service.MedicalTreatmentService;

@Service
@Transactional
public class MedicalTreatmentServiceImpl implements MedicalTreatmentService {
    private final MedicalTreatmentDao medicalTreatmentDao;

    @Autowired
    public MedicalTreatmentServiceImpl(MedicalTreatmentDao pMedicalTreatmentDao) {
        medicalTreatmentDao = pMedicalTreatmentDao;
    }

    @Override
    public MedicalTreatmentTO findById(Long id) {
        final MedicalTreatmentEntity entity = medicalTreatmentDao.findOne(id);
        return MedicalTreatmentMapper.mapToTO(entity);
    }
}

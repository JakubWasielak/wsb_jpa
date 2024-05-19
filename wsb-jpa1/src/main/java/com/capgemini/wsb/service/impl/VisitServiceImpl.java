package com.capgemini.wsb.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.VisitService;

@Service
@Transactional
public class VisitServiceImpl implements VisitService {
    private final VisitDao visitDao;

    @Autowired
    public VisitServiceImpl(VisitDao pVisitDao) {
        visitDao = pVisitDao;
    }

    @Override
    public VisitTO findById(Long id) {
        final VisitEntity entity = visitDao.findOne(id);
        return VisitMapper.mapToTO(entity);
    }

    @Override
    public List<VisitTO> findVisitsByPatientId(Long id) {
        final List<VisitEntity> visitsEntity = visitDao.findVisitsByPatientId(id);
        return VisitMapper.mapToTOList(visitsEntity);
    }
}

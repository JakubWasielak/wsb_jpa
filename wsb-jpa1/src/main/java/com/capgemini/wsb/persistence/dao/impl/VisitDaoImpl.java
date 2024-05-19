package com.capgemini.wsb.persistence.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.VisitEntity;

@Repository
public class VisitDaoImpl extends AbstractDao<VisitEntity, Long> implements VisitDao {

    @Override
    public List<VisitEntity> findVisitsByPatientId(Long id) {
        TypedQuery<VisitEntity> query = entityManager.createQuery(
            "SELECT visit FROM VisitEntity visit JOIN visit.patient patient WHERE patient.id LIKE :param",
            VisitEntity.class);
        query.setParameter("param", id);
        return query.getResultList();
    }

}

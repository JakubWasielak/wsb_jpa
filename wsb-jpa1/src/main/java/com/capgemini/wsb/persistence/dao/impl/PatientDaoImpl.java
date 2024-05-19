package com.capgemini.wsb.persistence.dao.impl;

import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Override
    public List<PatientEntity> findByLastName(String lastName) {
       TypedQuery<PatientEntity> query = entityManager.createQuery(
            "SELECT p FROM PatientEntity p WHERE p.lastName LIKE :param", 
            PatientEntity.class
        );
        query.setParameter("param", lastName);
        return query.getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsWithMoreThanVisits(int visitsCount) {
        long visitsCountLong = visitsCount;
        TypedQuery<PatientEntity> query = entityManager.createQuery(
            "SELECT p FROM PatientEntity p JOIN p.visits v GROUP BY p.id HAVING COUNT(v) > :param",
            PatientEntity.class
        );
        query.setParameter("param", visitsCountLong);
        return query.getResultList();
    }

    @Override
    public long countPatientsWithInsurance() {
        TypedQuery<Long> query = entityManager.createQuery(
            "SELECT COUNT(p) FROM PatientEntity p WHERE p.hasInsurance = true",
            Long.class
        );
        return query.getSingleResult();
    }
}

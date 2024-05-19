package com.capgemini.wsb.persistance.dao;

import org.junit.Test;
import java.util.List;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.service.VisitService;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientJpqlTest {

    @Autowired
    private VisitService visitService;

    @Autowired
    private PatientDao patientDao;


    @Test
    public void testFindByLastName() {
        // given
        final String lastName = "Doe";

        // when
        final List<PatientEntity> patients = patientDao.findByLastName(lastName);

        // then
        assertThat(patients).isNotEmpty();
        assertThat(patients.get(0).getLastName()).isEqualTo(lastName);
    }

    @Test
    public void testFindVisitsByPatientId() {
        // given
        final long patinetId = 1L;

        // when
        final List<VisitTO> visist = visitService.findVisitsByPatientId(patinetId);

        // then
        assertThat(visist).isNotEmpty();
        assertThat(visist.get(0).getDescription()).isEqualTo("Check-up");
    }
    
    @Test
    public void testFindPatientsWithMoreThanVisits() {
        // given

        // when
        final List<PatientEntity> patients = patientDao.findPatientsWithMoreThanVisits(1);

        // then
        assertThat(patients).isNotNull();
        assertThat(patients).hasSize(1);
    }

    @Test
    public void testCountPatientsWithInsurance() {
        // given

        // when
        long count = patientDao.countPatientsWithInsurance();

        // then
        assertThat(count).isEqualTo(3);
    }
}   

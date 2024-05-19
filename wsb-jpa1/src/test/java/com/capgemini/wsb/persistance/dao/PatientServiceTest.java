package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.service.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest
{
    @Autowired
    private PatientDao patientDao;

    @Autowired
    private VisitDao visitDao;

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private PatientService patientService;

    @Transactional
    @Test
    public void testShouldRemovePatientWithCascade() {
        // given
        long patientId = 1L;
        long patientNumBefore = patientDao.count();
        long visitNumBefore = visitDao.count();
        long patientVisitCount = patientService.findById(patientId).getVisits().size();
        long doctorNumBefore = doctorDao.count();

        // when
        patientService.deleteById(patientId);

        // then
        assertThat(patientDao.count()).isEqualTo(patientNumBefore - 1);
        assertThat(visitDao.count()).isEqualTo(visitNumBefore - patientVisitCount);
        assertThat(doctorDao.count()).isEqualTo(doctorNumBefore);

        PatientTO patientTO = patientService.findById(patientId);
        assertThat(patientTO).isNull();
    }

    @Test
    public void testFindByIdShouldReturnCorrectTO() {
        // given
        long patientId = 1L;
        PatientTO patientTO = patientService.findById(patientId);

        // then
        assertThat(patientTO).isNotNull();
        assertThat(patientTO.getId()).isEqualTo(patientId);
        assertThat(patientTO.getFirstName()).isEqualTo("John");
        assertThat(patientTO.getLastName()).isEqualTo("Doe");
        assertThat(patientTO.getTelephoneNumber()).isEqualTo("+1234567890");
        assertThat(patientTO.getEmail()).isEqualTo("john.doe@example.com");
        assertThat(patientTO.getPatientNumber()).isEqualTo("P001");
        assertThat(patientTO.getDateOfBirth()).isEqualTo("1990-05-15");
        assertThat(patientTO.isHasInsurance()).isTrue();
        assertThat(patientTO.getAddress().getId()).isEqualTo(2L);
    }
}

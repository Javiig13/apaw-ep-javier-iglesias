package es.upm.miw.apaw_ep_javier_iglesias.business_controllers;

import es.upm.miw.apaw_ep_javier_iglesias.TestConfig;
import es.upm.miw.apaw_ep_javier_iglesias.daos.DoctorDao;
import es.upm.miw.apaw_ep_javier_iglesias.documents.Doctor;
import es.upm.miw.apaw_ep_javier_iglesias.dtos.DoctorDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class DoctorControllerIT {

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private DoctorBusinessController doctorBusinessController;

    private Doctor doctor;

    @BeforeEach
    void before() {
        this.doctor = new Doctor("oldName", "123A", LocalDateTime.now(), null);
        this.doctorDao.save(doctor);
    }

    @Test
    void testPatchName() {
        DoctorDto doctorDto = new DoctorDto("oldName", "newName");
        doctorBusinessController.patch(this.doctor.getId(), doctorDto);
        assertEquals("newName", Objects.requireNonNull(this.doctorDao.findById(doctor.getId()).orElse(null)).getName());
    }

    @AfterEach
    void after() {
        this.doctorDao.deleteById(this.doctor.getId());
    }

}

package es.upm.miw.apaw_ep_javier_iglesias.patterns_tests;

import es.upm.miw.apaw_ep_javier_iglesias.ApiTestConfig;
import es.upm.miw.apaw_ep_javier_iglesias.documents.Doctor;
import es.upm.miw.apaw_ep_javier_iglesias.patterns.DoctorBuilder;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ApiTestConfig
public class PatternsIT {

    @Test
    public void testCreateDoctorWithBuilder() {
        DoctorBuilder doctorBuilder = new DoctorBuilder();

        Doctor doctor = doctorBuilder
                .withName("Dr. Fernandez")
                .withCollegiateNumber("AAA-123")
                .withCollegiateDate(LocalDateTime.now())
                .withInternals(null).build();
        assertNotNull(doctor);
    }
}

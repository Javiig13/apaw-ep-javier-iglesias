package es.upm.miw.apaw_ep_javier_iglesias.patterns;

import es.upm.miw.apaw_ep_javier_iglesias.documents.Doctor;
import es.upm.miw.apaw_ep_javier_iglesias.documents.Internal;
import es.upm.miw.apaw_ep_javier_iglesias.patterns.builder.DoctorBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DoctorBuilderTest {

    private Doctor doctor;
    private DoctorBuilder doctorBuilder;

    @BeforeEach
    void setUp() {
        doctorBuilder = new DoctorBuilder();

        List<Internal> internals = new ArrayList<Internal>() {{
            add(new Internal("1", "Pedro", true));
        }};

        doctor = doctorBuilder
                .withName("Dr. Fernandez")
                .withCollegiateNumber("AAA-123")
                .withCollegiateDate(LocalDateTime.now())
                .withInternals(internals).build();
        assertNotNull(doctor);
    }

    @Test
    void withName() {
        assertNotNull(doctor.getName());
    }

    @Test
    void withCollegiateNumber() {
        assertNotNull(doctor.getCollegiateNumber());
    }

    @Test
    void withCollegiateDate() {
        assertNotNull(doctor.getCollegiateDate());
    }

    @Test
    void withInternals() {
        assertFalse(0 >= doctor.getInternals().size());
    }

    @Test
    void build() {
        assertNotNull(doctor);
    }
}
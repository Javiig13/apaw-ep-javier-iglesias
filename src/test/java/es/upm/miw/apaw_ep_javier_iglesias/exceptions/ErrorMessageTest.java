package es.upm.miw.apaw_ep_javier_iglesias.exceptions;

import es.upm.miw.apaw_ep_javier_iglesias.documents.Internal;
import es.upm.miw.apaw_ep_javier_iglesias.dtos.DoctorDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ErrorMessageTest {

    private DoctorDto doctorDto;
    private Exception exception;
    private String path;

    @BeforeEach
    void setUp() {
        List<Internal> internals = new ArrayList<Internal>() {{
            add(new Internal("1", "Pedro", true));
        }};

        doctorDto = new DoctorDto("", "ASD-456", LocalDateTime.now(), internals);
        try {
            doctorDto.validate();
        } catch (Exception ex) {
            path = "DoctorDto validate";
            exception = ex;
        }
    }

    @Test
    void getError() {
        assertNotNull(exception.getClass().getSimpleName());
    }

    @Test
    void getMessage() {
        assertNotNull(exception.getMessage());
    }

    @Test
    void getPath() {
        assertNotNull(path);
    }

    @Test
    void testToString() {
        assertNotNull(exception.toString());
    }
}
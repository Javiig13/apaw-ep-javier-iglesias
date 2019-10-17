package es.upm.miw.apaw_ep_javier_iglesias.api_controllers;

import es.upm.miw.apaw_ep_javier_iglesias.ApiTestConfig;
import es.upm.miw.apaw_ep_javier_iglesias.documents.Internal;
import es.upm.miw.apaw_ep_javier_iglesias.dtos.DoctorDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ApiTestConfig
class DoctorResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        ArrayList<Internal> internals = new ArrayList<Internal>() {{
            add(new Internal("Javier", true));
        }};

        DoctorDto doctorDto = this.webTestClient
                .post().uri(DoctorResource.DOCTORS)
                .body(BodyInserters.fromObject(new DoctorDto("Juan", "123777-A", LocalDateTime.now(), internals)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(DoctorDto.class).returnResult().getResponseBody();
        assertNotNull(doctorDto);
        assertFalse(doctorDto.getInternals().size() <= 0);
        assertEquals("123777-A", doctorDto.getCollegiateNumber());
    }
}

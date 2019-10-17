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
import java.util.List;
import java.util.Objects;

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

    void createDoctors() {
        DoctorDto doctorDto = new DoctorDto("Javier", "50", LocalDateTime.now(), null);
        this.webTestClient
                .post().uri(DoctorResource.DOCTORS)
                .body(BodyInserters.fromObject(doctorDto))
                .exchange()
                .expectStatus().isOk();

        DoctorDto anotherDoctorDto = new DoctorDto("Jacinto", "65", LocalDateTime.now(), null);
        this.webTestClient
                .post().uri(DoctorResource.DOCTORS)
                .body(BodyInserters.fromObject(anotherDoctorDto))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testSearchParamsFindDoctorsByName() {
        createDoctors();
        List<DoctorDto> doctors = this.webTestClient
                .get().uri(uriBuilder ->
                        uriBuilder.path(DoctorResource.DOCTORS + DoctorResource.SEARCH)
                                .queryParam("q", "name=Ja")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(DoctorDto.class)
                .returnResult().getResponseBody();
        assertFalse(Objects.requireNonNull(doctors).isEmpty());
    }
}

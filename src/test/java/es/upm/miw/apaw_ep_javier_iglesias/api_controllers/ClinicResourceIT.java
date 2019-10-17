package es.upm.miw.apaw_ep_javier_iglesias.api_controllers;

import es.upm.miw.apaw_ep_javier_iglesias.ApiTestConfig;
import es.upm.miw.apaw_ep_javier_iglesias.dtos.ClinicDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.*;

@ApiTestConfig
class ClinicResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        ClinicDto clinicDto = this.webTestClient
                .post().uri(ClinicResource.CLINICS)
                .body(BodyInserters.fromObject(new ClinicDto("Clinic Example", null)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(ClinicDto.class).returnResult().getResponseBody();
        assertNotNull(clinicDto);
        assertNotNull(clinicDto.getName());
        assertEquals("Clinic Example", clinicDto.getName());
    }

}

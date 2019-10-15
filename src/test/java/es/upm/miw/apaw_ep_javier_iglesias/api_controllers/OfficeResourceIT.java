package es.upm.miw.apaw_ep_javier_iglesias.api_controllers;

import es.upm.miw.apaw_ep_javier_iglesias.ApiTestConfig;
import es.upm.miw.apaw_ep_javier_iglesias.dtos.OfficeDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.*;

@ApiTestConfig
class OfficeResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        OfficeDto officeDto = this.webTestClient
                .post().uri(OfficeResource.OFFICES)
                .body(BodyInserters.fromObject(new OfficeDto(125)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(OfficeDto.class).returnResult().getResponseBody();
        assertNotNull(officeDto);
        assertFalse(officeDto.getSquareMeters() <= 0);
        assertEquals(java.util.Optional.of(125), java.util.Optional.of(officeDto.getSquareMeters()));
    }
}

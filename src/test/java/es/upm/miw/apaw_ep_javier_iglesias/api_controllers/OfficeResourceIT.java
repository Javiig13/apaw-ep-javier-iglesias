package es.upm.miw.apaw_ep_javier_iglesias.api_controllers;

import es.upm.miw.apaw_ep_javier_iglesias.ApiTestConfig;
import es.upm.miw.apaw_ep_javier_iglesias.dtos.OfficeDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Objects;

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

    @Test
    void testPutSquareMeters() {
        String id = createOffice(35).getId();
        OfficeDto officeDto = new OfficeDto();
        officeDto.setSquareMeters(70);
        this.webTestClient
                .put().uri(OfficeResource.OFFICES + OfficeResource.ID_ID + OfficeResource.SQUARE_METERS, id)
                .body(BodyInserters.fromObject(officeDto))
                .exchange()
                .expectStatus().isOk();
        officeDto = this.webTestClient
                .get().uri(OfficeResource.OFFICES + OfficeResource.ID_ID + OfficeResource.SQUARE_METERS, id)
                .exchange()
                .expectStatus().isOk()
                .expectBody(OfficeDto.class)
                .returnResult().getResponseBody();
        assertEquals(id, Objects.requireNonNull(officeDto).getId());
        assertEquals(java.util.Optional.of(70), java.util.Optional.ofNullable(officeDto.getSquareMeters()));
    }

    OfficeDto createOffice(Integer squareMeters) {
        OfficeDto officeCreationDto = new OfficeDto(squareMeters);
        return this.webTestClient
                .post().uri(OfficeResource.OFFICES)
                .body(BodyInserters.fromObject(officeCreationDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(OfficeDto.class)
                .returnResult().getResponseBody();
    }
}

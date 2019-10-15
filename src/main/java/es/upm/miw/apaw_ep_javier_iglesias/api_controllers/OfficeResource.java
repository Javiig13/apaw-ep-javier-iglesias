package es.upm.miw.apaw_ep_javier_iglesias.api_controllers;

import es.upm.miw.apaw_ep_javier_iglesias.business_controllers.OfficeBusinessController;
import es.upm.miw.apaw_ep_javier_iglesias.dtos.OfficeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(OfficeResource.OFFICES)
public class OfficeResource {

    static final String OFFICES = "/offices";
    private static final String ID_ID = "/{id}";
    private static final String SQUARE_METERS = "/squareMeters";

    private OfficeBusinessController officeBusinessController;

    @Autowired
    public OfficeResource(OfficeBusinessController officeBusinessController) {
        this.officeBusinessController = officeBusinessController;
    }

    @PostMapping
    public OfficeDto create(@RequestBody OfficeDto officeDto) {
        officeDto.validate();
        return this.officeBusinessController.create(officeDto);
    }

    @PutMapping(value = ID_ID + SQUARE_METERS)
    public void updateNick(@PathVariable String id, @RequestBody OfficeDto officeDto) {
        officeDto.validate();
        this.officeBusinessController.updateSquareMeters(id, officeDto.getSquareMeters());
    }
}

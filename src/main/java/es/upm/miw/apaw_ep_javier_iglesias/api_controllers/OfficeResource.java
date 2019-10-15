package es.upm.miw.apaw_ep_javier_iglesias.api_controllers;

import es.upm.miw.apaw_ep_javier_iglesias.business_controllers.OfficeBusinessController;
import es.upm.miw.apaw_ep_javier_iglesias.dtos.OfficeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(OfficeResource.OFFICES)
public class OfficeResource {

    static final String OFFICES = "/offices";

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
}

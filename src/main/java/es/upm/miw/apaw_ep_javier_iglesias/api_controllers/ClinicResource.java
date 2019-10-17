package es.upm.miw.apaw_ep_javier_iglesias.api_controllers;

import es.upm.miw.apaw_ep_javier_iglesias.business_controllers.ClinicBusinessController;
import es.upm.miw.apaw_ep_javier_iglesias.dtos.ClinicDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ClinicResource.CLINICS)
public class ClinicResource {

    static final String CLINICS = "/clinics";

    private ClinicBusinessController clinicBusinessController;

    @Autowired
    public ClinicResource(ClinicBusinessController clinicBusinessController) {
        this.clinicBusinessController = clinicBusinessController;
    }

    @PostMapping
    public ClinicDto create(@RequestBody ClinicDto clinicDto) {
        clinicDto.validate();
        return this.clinicBusinessController.create(clinicDto);
    }
}

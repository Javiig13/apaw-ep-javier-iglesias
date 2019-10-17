package es.upm.miw.apaw_ep_javier_iglesias.api_controllers;

import es.upm.miw.apaw_ep_javier_iglesias.business_controllers.DoctorBusinessController;
import es.upm.miw.apaw_ep_javier_iglesias.dtos.DoctorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DoctorResource.DOCTORS)
public class DoctorResource {

    static final String DOCTORS = "/doctors";

    private DoctorBusinessController doctorBusinessController;

    @Autowired
    public DoctorResource(DoctorBusinessController doctorBusinessController) {
        this.doctorBusinessController = doctorBusinessController;
    }

    @PostMapping
    public DoctorDto create(@RequestBody DoctorDto doctorDto) {
        doctorDto.validate();
        return this.doctorBusinessController.create(doctorDto);
    }
}

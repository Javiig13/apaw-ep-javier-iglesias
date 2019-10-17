package es.upm.miw.apaw_ep_javier_iglesias.api_controllers;

import es.upm.miw.apaw_ep_javier_iglesias.business_controllers.DoctorBusinessController;
import es.upm.miw.apaw_ep_javier_iglesias.dtos.DoctorDto;
import es.upm.miw.apaw_ep_javier_iglesias.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(DoctorResource.DOCTORS)
class DoctorResource {

    static final String DOCTORS = "/doctors";
    static final String SEARCH = "/search";
    private static final String ID_ID = "/{id}";

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

    @GetMapping(value = SEARCH)
    public List<DoctorDto> find(@RequestParam String q) {
        if (!"name".equals(q.split("=")[0])) {
            throw new BadRequestException("query param q is incorrect, missing 'name='");
        }
        return this.doctorBusinessController.findByDoctorNameStartsWith(q.split("=")[1]);
    }

    @PatchMapping(value = ID_ID)
    public void patch(@PathVariable String id, @RequestBody DoctorDto doctorDto) {
        doctorDto.validateNewValue();
        this.doctorBusinessController.patch(id, doctorDto);
    }
}

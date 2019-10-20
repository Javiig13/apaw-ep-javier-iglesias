package es.upm.miw.apaw_ep_javier_iglesias.api_controllers;

import es.upm.miw.apaw_ep_javier_iglesias.business_controllers.DoctorBusinessController;
import es.upm.miw.apaw_ep_javier_iglesias.daos.DoctorDao;
import es.upm.miw.apaw_ep_javier_iglesias.documents.Doctor;
import es.upm.miw.apaw_ep_javier_iglesias.dtos.DoctorDto;
import es.upm.miw.apaw_ep_javier_iglesias.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(DoctorResource.DOCTORS)
class DoctorResource {

    static final String DOCTORS = "/doctors";
    static final String INTERNALS = "/internals";
    static final String SEARCH = "/search";
    static final String ID_ID = "/{id}";
    static final String ID_INTERNAL = "/{idInternal}";

    private DoctorBusinessController doctorBusinessController;
    private DoctorDao doctorDao;

    @Autowired
    public DoctorResource(DoctorBusinessController doctorBusinessController, DoctorDao doctorDao) {
        this.doctorBusinessController = doctorBusinessController;
        this.doctorDao = doctorDao;
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

    @DeleteMapping(value = ID_ID + INTERNALS + ID_INTERNAL)
    public void delete(@PathVariable String id, @PathVariable String idInternal) {
        Doctor doctor = doctorBusinessController.findDoctorById(id);
        doctor.getInternals().removeIf(internal -> internal.getId().equals(idInternal));
        this.doctorDao.save(doctor);
    }
}

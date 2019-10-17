package es.upm.miw.apaw_ep_javier_iglesias.business_controllers;

import es.upm.miw.apaw_ep_javier_iglesias.daos.DoctorDao;
import es.upm.miw.apaw_ep_javier_iglesias.documents.Doctor;
import es.upm.miw.apaw_ep_javier_iglesias.dtos.DoctorDto;
import es.upm.miw.apaw_ep_javier_iglesias.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DoctorBusinessController {

    private DoctorDao doctorDao;

    @Autowired
    public DoctorBusinessController(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    public DoctorDto create(DoctorDto doctorDto) {
        Doctor doctor = new Doctor(doctorDto.getName(), doctorDto.getCollegiateNumber(), doctorDto.getCollegiateDate(),
                doctorDto.getInternals());
        this.doctorDao.save(doctor);
        return new DoctorDto(doctor);
    }

    public List<DoctorDto> findByDoctorNameStartsWith(String query) {
        return this.doctorDao.findAll().stream()
                .filter(p -> p.getName().startsWith(query))
                .map(DoctorDto::new).collect(Collectors.toList());
    }

    public void patch(String id, DoctorDto doctorDto) {
        Doctor doctor = this.findDoctorById(id);
        doctor.setName(doctorDto.getNewName());
        this.doctorDao.save(doctor);
    }

    private Doctor findDoctorById(String id) {
        return this.doctorDao.findById(id).orElseThrow(() -> new NotFoundException("Doctor id: " + id));
    }
}

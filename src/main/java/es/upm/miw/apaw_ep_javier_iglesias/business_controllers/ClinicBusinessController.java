package es.upm.miw.apaw_ep_javier_iglesias.business_controllers;

import es.upm.miw.apaw_ep_javier_iglesias.daos.ClinicDao;
import es.upm.miw.apaw_ep_javier_iglesias.documents.Clinic;
import es.upm.miw.apaw_ep_javier_iglesias.dtos.ClinicDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ClinicBusinessController {

    private ClinicDao clinicDao;

    @Autowired
    public ClinicBusinessController(ClinicDao clinicDao) {
        this.clinicDao = clinicDao;
    }

    public ClinicDto create(ClinicDto clinicDto) {
        Clinic clinic = new Clinic(clinicDto.getName(), clinicDto.getDoctorList());
        this.clinicDao.save(clinic);
        return new ClinicDto(clinic);
    }
}

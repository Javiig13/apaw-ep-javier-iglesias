package es.upm.miw.apaw_ep_javier_iglesias.business_controllers;

import es.upm.miw.apaw_ep_javier_iglesias.daos.OfficeDao;
import es.upm.miw.apaw_ep_javier_iglesias.documents.Office;
import es.upm.miw.apaw_ep_javier_iglesias.dtos.OfficeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OfficeBusinessController {

    private OfficeDao officeDao;

    @Autowired

    public OfficeBusinessController(OfficeDao officeDao) {
        this.officeDao = officeDao;
    }

    public OfficeDto create(OfficeDto officeDto) {
        Office office = new Office(officeDto.getSquareMeters());
        this.officeDao.save(office);
        return new OfficeDto(office);
    }
}

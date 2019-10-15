package es.upm.miw.apaw_ep_javier_iglesias.business_controllers;

import es.upm.miw.apaw_ep_javier_iglesias.daos.OfficeDao;
import es.upm.miw.apaw_ep_javier_iglesias.documents.Office;
import es.upm.miw.apaw_ep_javier_iglesias.dtos.OfficeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import es.upm.miw.apaw_ep_javier_iglesias.exceptions.NotFoundException;

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

    public void updateSquareMeters(String id, Integer squareMeters) {
        Office office = this.findOfficeById(id);
        office.setSquareMeters(squareMeters);
        this.officeDao.save(office);
    }

    private Office findOfficeById(String id) {
        return this.officeDao.findById(id).orElseThrow(() -> new NotFoundException("Office id: " + id));
    }
}

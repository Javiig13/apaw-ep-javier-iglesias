package es.upm.miw.apaw_ep_javier_iglesias.patterns.composite;

import java.util.ArrayList;
import java.util.List;

public class HeadOffice implements Office {

    private List<Office> officeList;

    public HeadOffice() {
        this.officeList = new ArrayList<>();
    }

    @Override
    public void printSquareMeters() {
        officeList.forEach(Office::printSquareMeters);
    }

    public void addOffice(Office office) {
        officeList.add(office);
    }

    public void removeOffice(Office office) {
        officeList.remove(office);
    }

    public List<Office> getOfficeList() {
        return officeList;
    }
}

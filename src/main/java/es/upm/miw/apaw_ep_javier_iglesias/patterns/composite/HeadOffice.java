package es.upm.miw.apaw_ep_javier_iglesias.patterns.composite;

import java.util.List;

public class HeadOffice implements Office {

    private Integer squareMeters;

    private List<Office> officeList;

    public HeadOffice(Integer squareMeters, List<Office> officeList) {
        this.squareMeters = squareMeters;
        this.officeList = officeList;
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
}

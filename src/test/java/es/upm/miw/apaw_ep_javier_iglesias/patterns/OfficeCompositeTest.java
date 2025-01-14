package es.upm.miw.apaw_ep_javier_iglesias.patterns;

import es.upm.miw.apaw_ep_javier_iglesias.patterns.composite.HeadOffice;
import es.upm.miw.apaw_ep_javier_iglesias.patterns.composite.ModernOffice;
import es.upm.miw.apaw_ep_javier_iglesias.patterns.composite.OldOffice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class OfficeCompositeTest {

    @Test
    void createComposite() {
        ModernOffice modernOffice = new ModernOffice(70);
        OldOffice oldOffice = new OldOffice(30);
        HeadOffice headOffice = new HeadOffice();

        headOffice.addOffice(modernOffice);
        headOffice.addOffice(oldOffice);

        headOffice.printSquareMeters();

        headOffice.removeOffice(oldOffice);

        headOffice.printSquareMeters();

        assertTrue(headOffice.getOfficeList().size() > 0);
    }
}

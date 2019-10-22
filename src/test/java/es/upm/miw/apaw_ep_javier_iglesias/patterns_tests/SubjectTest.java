package es.upm.miw.apaw_ep_javier_iglesias.patterns_tests;

import es.upm.miw.apaw_ep_javier_iglesias.documents.Office;
import es.upm.miw.apaw_ep_javier_iglesias.patterns.publish.Observable;
import es.upm.miw.apaw_ep_javier_iglesias.patterns.publish.ObserverA;
import es.upm.miw.apaw_ep_javier_iglesias.patterns.publish.ObserverB;
import es.upm.miw.apaw_ep_javier_iglesias.patterns.publish.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubjectTest {

    private Office office;
    private Subject subject;

    @BeforeEach
    void setUp() {
        subject = new Subject();
        office = new Office(56);
        subject.setOffice(office);
        assertNotNull(office);
    }

    @Test
    void getOffice() {
        assertNotNull(subject.getOffice());
    }
}
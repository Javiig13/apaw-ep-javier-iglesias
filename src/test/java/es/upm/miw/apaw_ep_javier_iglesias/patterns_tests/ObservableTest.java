package es.upm.miw.apaw_ep_javier_iglesias.patterns_tests;

import es.upm.miw.apaw_ep_javier_iglesias.patterns.publish.Observable;
import es.upm.miw.apaw_ep_javier_iglesias.patterns.publish.ObserverA;
import es.upm.miw.apaw_ep_javier_iglesias.patterns.publish.ObserverB;
import es.upm.miw.apaw_ep_javier_iglesias.patterns.publish.Subject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObservableTest {

    private Observable observable;
    private ObserverA observerA;
    private ObserverB observerB;
    private Subject subject;

    @BeforeEach
    void setUp() {
        observable = new Observable();
        subject = new Subject();
        observerA = new ObserverA(subject);
        observerB = new ObserverB(subject);
    }

    @Test
    void addObserver() {
        observable.addObserver(observerA);
        observable.addObserver(observerB);
        assertNotNull(observable);
    }

    @Test
    void removeObserver() {
        observable.removeObserver(observerA);
        assertNotNull(observable);
    }
}
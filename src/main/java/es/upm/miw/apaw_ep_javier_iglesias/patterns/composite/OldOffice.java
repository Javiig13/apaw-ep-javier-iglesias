package es.upm.miw.apaw_ep_javier_iglesias.patterns.composite;

import org.apache.logging.log4j.LogManager;

public class OldOffice implements Office {

    private Integer squareMeters;

    @Override
    public void printSquareMeters() {
        LogManager.getLogger(getClass().getSimpleName());
    }

    public OldOffice() {
        // empty for framework
    }

    public OldOffice(Integer squareMeters) {
        this.squareMeters = squareMeters;
    }

    public Integer getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(Integer squareMeters) {
        this.squareMeters = squareMeters;
    }
}
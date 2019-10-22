package es.upm.miw.apaw_ep_javier_iglesias.patterns.composite;

public class ModernOffice implements Office {

    private Integer squareMeters;

    @Override
    public void printSquareMeters() {
        System.out.println(getClass().getSimpleName());
    }

    public ModernOffice() {
        // empty for framework
    }

    public ModernOffice(Integer squareMeters) {
        this.squareMeters = squareMeters;
    }

    public Integer getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(Integer squareMeters) {
        this.squareMeters = squareMeters;
    }
}

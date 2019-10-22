package es.upm.miw.apaw_ep_javier_iglesias.patterns.composite;

public abstract class OfficeComponent {
    private Integer squareMeters;

    OfficeComponent(Integer squareMeters) {
        this.squareMeters = squareMeters;
    }

    Integer getSquareMeters() {
        return squareMeters;
    }

    public abstract void add(OfficeComponent oc);

    public abstract void remove(OfficeComponent oc);

    public abstract boolean isComposite();

    public abstract String view(String head);
}

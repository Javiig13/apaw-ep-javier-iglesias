package es.upm.miw.apaw_ep_javier_iglesias.patterns.composite;

public class Leaf2 extends OfficeComponent {

    public Leaf2(Integer squareMeters) {
        super(squareMeters);
    }

    @Override
    public void add(OfficeComponent oc) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public void remove(OfficeComponent oc) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public String view(String head) {
        return "Head2: " + this.getSquareMeters().toString();
    }

    @Override
    public String toString() {
        return "Leaf2: " + this.getSquareMeters();
    }
}
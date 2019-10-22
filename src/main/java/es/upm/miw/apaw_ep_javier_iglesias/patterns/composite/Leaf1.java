package es.upm.miw.apaw_ep_javier_iglesias.patterns.composite;

public class Leaf1 extends OfficeComponent {

    public Leaf1(Integer squareMeters) {
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
        return "Head1: " + this.getSquareMeters().toString();
    }

    @Override
    public String toString() {
        return "Leaf1: " + this.getSquareMeters();
    }
}

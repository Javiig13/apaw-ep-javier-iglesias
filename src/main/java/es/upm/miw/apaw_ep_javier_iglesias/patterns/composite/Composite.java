package es.upm.miw.apaw_ep_javier_iglesias.patterns.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite extends OfficeComponent {

    private List<OfficeComponent> officeComponents;

    public Composite(Integer squareMeters) {
        super(squareMeters);
        officeComponents = new ArrayList<>();
    }

    @Override
    public void add(OfficeComponent oc) {
        officeComponents.add(oc);
    }

    @Override
    public void remove(OfficeComponent oc) {
        officeComponents.remove(oc);
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public String view(String head) {
        StringBuilder result = new StringBuilder();
        result.append(head).append("-").append(this.getSquareMeters()).append(":").append("\n");
        for (OfficeComponent item : officeComponents) {
            result.append(item.view(head + "  "));
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return String.format("Composite: %d", this.getSquareMeters());
    }
}

package es.upm.miw.apaw_ep_javier_iglesias.patterns.Publish;

import es.upm.miw.apaw_ep_javier_iglesias.documents.Office;

public class Subject extends Observable {

    private Office office;

    Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
        this.notifyObservers();
    }
}
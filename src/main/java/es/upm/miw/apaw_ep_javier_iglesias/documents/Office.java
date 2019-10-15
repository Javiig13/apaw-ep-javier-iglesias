package es.upm.miw.apaw_ep_javier_iglesias.documents;

import org.springframework.data.annotation.Id;

public class Office {

    @Id
    private String id;

    private Double squareMeters;

    public Office(Double squareMeters) {
        this.squareMeters = squareMeters;
    }

    public String getId() {
        return id;
    }

    public Double getSquareMeters() {
        return squareMeters;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id='" + id + '\'' +
                ", squareMeters=" + squareMeters +
                '}';
    }
}

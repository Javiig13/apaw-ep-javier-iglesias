package es.upm.miw.apaw_ep_javier_iglesias.documents;

import org.springframework.data.annotation.Id;

public class Office {

    @Id
    private String id;

    private Integer squareMeters;

    public Office(Integer squareMeters) {
        this.squareMeters = squareMeters;
    }

    public String getId() {
        return id;
    }

    public Integer getSquareMeters() {
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

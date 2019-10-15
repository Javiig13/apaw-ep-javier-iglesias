package es.upm.miw.apaw_ep_javier_iglesias.dtos;

import es.upm.miw.apaw_ep_javier_iglesias.documents.Office;
import es.upm.miw.apaw_ep_javier_iglesias.exceptions.BadRequestException;

public class OfficeDto {

    private String id;

    private Integer squareMeters;

    public OfficeDto() {
        //empty
    }

    public OfficeDto(Integer squareMeters) {
        this.squareMeters = squareMeters;
    }

    public OfficeDto(Office office) {
        this.id = office.getId();
        this.squareMeters = office.getSquareMeters();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(Integer squareMeters) {
        this.squareMeters = squareMeters;
    }

    public void validate() {
        if (squareMeters == null || squareMeters <= 0) {
            throw new BadRequestException("The office has incorrect data.");
        }
    }

    @Override
    public String toString() {
        return "OfficeDto{" +
                "id='" + id + '\'' +
                ", squareMeters=" + squareMeters +
                '}';
    }
}

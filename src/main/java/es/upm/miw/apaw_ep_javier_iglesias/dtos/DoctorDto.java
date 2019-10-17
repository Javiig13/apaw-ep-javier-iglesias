package es.upm.miw.apaw_ep_javier_iglesias.dtos;

import es.upm.miw.apaw_ep_javier_iglesias.documents.Doctor;
import es.upm.miw.apaw_ep_javier_iglesias.documents.Internal;
import es.upm.miw.apaw_ep_javier_iglesias.exceptions.BadRequestException;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class DoctorDto {

    private String id;

    private String name;

    private String collegiateNumber;

    private LocalDateTime collegiateDate;

    private ArrayList<Internal> internals;

    public DoctorDto() {
        //empty
    }

    public DoctorDto(String name, String collegiateNumber, LocalDateTime collegiateDate, ArrayList<Internal> internals) {
        this.name = name;
        this.collegiateNumber = collegiateNumber;
        this.collegiateDate = collegiateDate;
        this.internals = internals;
    }

    public DoctorDto(Doctor doctor) {
        this.id = doctor.getId();
        this.name = doctor.getName();
        this.collegiateNumber = doctor.getCollegiateNumber();
        this.collegiateDate = doctor.getCollegiateDate();
        this.internals = doctor.getInternals();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollegiateNumber() {
        return collegiateNumber;
    }

    public void setCollegiateNumber(String collegiateNumber) {
        this.collegiateNumber = collegiateNumber;
    }

    public LocalDateTime getCollegiateDate() {
        return collegiateDate;
    }

    public void setCollegiateDate(LocalDateTime collegiateDate) {
        this.collegiateDate = collegiateDate;
    }

    public ArrayList<Internal> getInternals() {
        return internals;
    }

    public void setInternals(ArrayList<Internal> internals) {
        this.internals = internals;
    }

    public void validate() {
        if (name.isEmpty() || collegiateDate.isAfter(LocalDateTime.now()) ||
                collegiateNumber.isEmpty()|| internals.isEmpty()) {
            throw new BadRequestException("Incomplete DoctorDto. ");
        }
    }

    @Override
    public String toString() {
        return "DoctorDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", collegiateNumber='" + collegiateNumber + '\'' +
                ", collegiateDate=" + collegiateDate +
                ", internals=" + internals +
                '}';
    }
}
package es.upm.miw.apaw_ep_javier_iglesias.dtos;

import es.upm.miw.apaw_ep_javier_iglesias.documents.Doctor;
import es.upm.miw.apaw_ep_javier_iglesias.documents.Internal;
import es.upm.miw.apaw_ep_javier_iglesias.exceptions.BadRequestException;

import java.time.LocalDateTime;
import java.util.List;

public class DoctorDto {

    private String id;

    private String name;

    private String collegiateNumber;

    private LocalDateTime collegiateDate;

    private List<Internal> internals;

    private String oldName;

    private String newName;

    public DoctorDto() {
        //empty
    }

    public DoctorDto(String name, String collegiateNumber, LocalDateTime collegiateDate, List<Internal> internals) {
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

    public DoctorDto(String oldName, String newName) {
        this.oldName = oldName;
        this.newName = newName;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
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

    public List<Internal> getInternals() {
        return internals;
    }

    public void setInternals(List<Internal> internals) {
        this.internals = internals;
    }

    public void validate() {
        if (name.isEmpty() || collegiateDate.isAfter(LocalDateTime.now()) || collegiateNumber.isEmpty()) {
            throw new BadRequestException("Incomplete DoctorDto. ");
        }
    }

    public void validateNewValue() {
        if (newName.isEmpty() || (oldName.equals(newName))) {
            throw new BadRequestException("Can't patch, new value is undefined or is the same that old value.");
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

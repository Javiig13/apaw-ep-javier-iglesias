package es.upm.miw.apaw_ep_javier_iglesias.dtos;

import es.upm.miw.apaw_ep_javier_iglesias.documents.Clinic;
import es.upm.miw.apaw_ep_javier_iglesias.documents.Doctor;
import es.upm.miw.apaw_ep_javier_iglesias.exceptions.BadRequestException;

import java.util.List;

public class ClinicDto {

    private String id;

    private String name;

    private List<Doctor> doctorList;

    public ClinicDto() {
        //empty
    }

    public ClinicDto(String name, List<Doctor> doctorList) {
        this.name = name;
        this.doctorList = doctorList;
    }

    public ClinicDto(Clinic clinic) {
        this.id = clinic.getId();
        this.name = clinic.getName();
        this.doctorList = clinic.getDoctorList();
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

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    public void validate() {
        if (name.isEmpty() || doctorList != null) {
            throw new BadRequestException("Incomplete DoctorDto. ");
        }
    }

    @Override
    public String toString() {
        return "ClinicDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", doctorList=" + doctorList +
                '}';
    }
}

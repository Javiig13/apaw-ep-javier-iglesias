package es.upm.miw.apaw_ep_javier_iglesias.documents;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Clinic {

    @Id
    private String id;

    private String name;

    private List<Doctor> doctorList;

    public Clinic(String name, List<Doctor> doctorList) {
        this.name = name;
        this.doctorList = doctorList;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    @Override
    public String toString() {
        return "Clinic{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", doctorList=" + doctorList +
                '}';
    }
}

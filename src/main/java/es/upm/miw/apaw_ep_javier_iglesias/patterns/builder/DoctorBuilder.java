package es.upm.miw.apaw_ep_javier_iglesias.patterns.builder;

import es.upm.miw.apaw_ep_javier_iglesias.documents.Doctor;
import es.upm.miw.apaw_ep_javier_iglesias.documents.Internal;

import java.time.LocalDateTime;
import java.util.List;

public class DoctorBuilder implements IBuilder {
    private String name;

    private String collegiateNumber;

    private LocalDateTime collegiateDate;

    private List<Internal> internals;

    public DoctorBuilder() {
        //empty for builder construction on test.
    }

    public DoctorBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public DoctorBuilder withCollegiateNumber(String collegiateNumber) {
        this.collegiateNumber = collegiateNumber;
        return this;
    }

    public DoctorBuilder withCollegiateDate(LocalDateTime collegiateDate) {
        this.collegiateDate = collegiateDate;
        return this;
    }

    public DoctorBuilder withInternals(List<Internal> internals) {
        this.internals = internals;
        return this;
    }

    @Override
    public Doctor build() {
        Doctor doctor = new Doctor();
        doctor.setName(this.name);
        doctor.setCollegiateNumber(this.collegiateNumber);
        doctor.setCollegiateDate(this.collegiateDate);
        doctor.setInternals(this.internals);
        return doctor;
    }
}

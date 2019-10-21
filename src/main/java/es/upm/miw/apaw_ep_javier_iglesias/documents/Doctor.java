package es.upm.miw.apaw_ep_javier_iglesias.documents;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

public class Doctor {

    @Id
    private String id;

    private String name;

    private String collegiateNumber;

    private LocalDateTime collegiateDate;

    private List<Internal> internals;

    public Doctor() {
    }

    public Doctor(String name, String collegiateNumber, LocalDateTime collegiateDate, List<Internal> internals) {
        this.name = name;
        this.collegiateNumber = collegiateNumber;
        this.collegiateDate = collegiateDate;
        this.internals = internals;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCollegiateNumber() {
        return collegiateNumber;
    }

    public LocalDateTime getCollegiateDate() {
        return collegiateDate;
    }

    public List<Internal> getInternals() {
        return internals;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCollegiateNumber(String collegiateNumber) {
        this.collegiateNumber = collegiateNumber;
    }

    public void setCollegiateDate(LocalDateTime collegiateDate) {
        this.collegiateDate = collegiateDate;
    }

    public void setInternals(List<Internal> internals) {
        this.internals = internals;
    }
}

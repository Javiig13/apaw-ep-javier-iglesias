package es.upm.miw.apaw_ep_javier_iglesias.documents;

import org.springframework.data.annotation.Id;

public class Internal {
    @Id
    private String id;

    private String name;

    private Boolean isActive;

    public Internal() {
    }

    public Internal(String name, Boolean isActive) {
        this.name = name;
        this.isActive = isActive;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getActive() {
        return isActive;
    }

    @Override
    public String toString() {
        return "Internal{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}

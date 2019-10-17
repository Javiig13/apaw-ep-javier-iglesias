package es.upm.miw.apaw_ep_javier_iglesias.dtos;

public class InternalDto {
    private String id;

    private String name;

    private Boolean isActive;

    public InternalDto() {
    }

    public InternalDto(String name, Boolean isActive) {
        this.name = name;
        this.isActive = isActive;
    }

    public InternalDto(String id, String name, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "InternalDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}

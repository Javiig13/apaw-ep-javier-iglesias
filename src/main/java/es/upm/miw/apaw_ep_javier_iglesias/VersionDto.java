package es.upm.miw.apaw_ep_javier_iglesias;

public class VersionDto {

    private String version;

    public VersionDto() {
        // Empty for framework
    }

    VersionDto(String version) {
        this.version = version;
    }

    String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}

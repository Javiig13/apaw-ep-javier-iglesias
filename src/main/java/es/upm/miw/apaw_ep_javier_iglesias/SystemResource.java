package es.upm.miw.apaw_ep_javier_iglesias;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SystemResource.SYSTEM)
public class SystemResource {

    public static final String SYSTEM = "/system";
    public static final String VERSION = "/version";

    @Value("${application.name}")
    private String applicationName;

    @Value("${build.version}")
    private String buildVersion;

    @Value("${build.timestamp}")
    private String buildTimestamp;

    @GetMapping(SystemResource.VERSION)
    public VersionDto readVersion() { // http://localhost:8080/system/version
        return new VersionDto(this.applicationName + "::" + this.buildVersion + "::" + this.buildTimestamp);
    }
}
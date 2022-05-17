package maven.com.lguplus.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter @Setter
@Configuration
@ConfigurationProperties(prefix = "uplus.openapi")
public class UplusProperties {
    private String uplusUrl;
    private String uplusUrl2;
    private String clientId;
    private String clientSecret;

}

package com.rikkei.smarthub.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "langfuse")
@Getter
@Setter
public class LangfuseProperties {

    private String host = "https://cloud.langfuse.com";
    private String publicKey;
    private String secretKey;
    private String basicAuth;
}

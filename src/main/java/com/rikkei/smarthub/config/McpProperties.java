package com.rikkei.smarthub.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "smarthub.mcp")
@Getter
@Setter
public class McpProperties {

    private String serverCommand = "npx";
    private List<String> serverArgs = new ArrayList<>(List.of("-y", "@modelcontextprotocol/server-postgres"));
    private String databaseUrl;
    private SafeSql safeSql = new SafeSql();

    @Getter
    @Setter
    public static class SafeSql {
        private int maxLimit = 100;
        private boolean enforceReadOnly = true;
    }
}

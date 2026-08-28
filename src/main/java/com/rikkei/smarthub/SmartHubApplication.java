package com.rikkei.smarthub;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartHubApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SmartHubApplication.class);
        // Disable Spring Boot banner to ensure zero Stdio Pollution for MCP JSON-RPC
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}

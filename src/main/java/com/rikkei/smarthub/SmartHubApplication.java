package com.rikkei.smarthub;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartHubApplication {

    public static void main(String[] args) {
        // Load local .env file into System properties if present
        try {
            Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
            dotenv.entries().forEach(entry -> {
                if (System.getProperty(entry.getKey()) == null && System.getenv(entry.getKey()) == null) {
                    System.setProperty(entry.getKey(), entry.getValue());
                }
            });
        } catch (Exception ignored) {
        }

        SpringApplication app = new SpringApplication(SmartHubApplication.class);
        // Disable Spring Boot banner to ensure zero Stdio Pollution for MCP JSON-RPC
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}

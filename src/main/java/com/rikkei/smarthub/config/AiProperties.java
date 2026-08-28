package com.rikkei.smarthub.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "smarthub.ai")
@Getter
@Setter
public class AiProperties {

    private int maxIterations = 6;

    private double similarityThreshold = 0.7;

    private int chunkSize = 500;

    private int chunkOverlap = 50;

    private String defaultSystemPrompt = "Bạn là SmartHub AI - Trợ lý Logistics Thông minh của RikkeiExpress.";
}

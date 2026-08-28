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

    /**
     * Max iterations guard for Agent Tool calls (SRS 3.4 & 5.3: max-iterations <= 6).
     */
    private int maxIterations = 6;

    /**
     * Similarity threshold for Vector similarity search (Cosine Distance).
     */
    private double similarityThreshold = 0.7;

    /**
     * Chunk size for RAG document chunking.
     */
    private int chunkSize = 500;

    /**
     * Overlap character count for document chunking.
     */
    private int chunkOverlap = 50;

    /**
     * Default system prompt instructions.
     */
    private String defaultSystemPrompt = "Bạn là SmartHub AI - Trợ lý Logistics Thông minh của RikkeiExpress.";
}

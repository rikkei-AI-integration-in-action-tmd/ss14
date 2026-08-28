package com.rikkei.smarthub.dto.llmops;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TraceMetricsDto {

    private String traceId;
    private String spanId;
    private String name;
    private Long latencyMs;
    private Integer promptTokens;
    private Integer completionTokens;
    private Integer totalTokens;
    private BigDecimal estimatedCostUsd;
    private String model;
    private String status;
    private LocalDateTime timestamp;
}

package com.rikkei.smarthub.dto.mcp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HubAnalyticsDto {

    private String hubCode;
    private long totalDeliveries;
    private long inTransitCount;
    private long deliveredCount;
    private long delayedCount;
    private long damagedCount;
    private long openIncidentsCount;
    private double delayRate;
    private double damageRate;
}

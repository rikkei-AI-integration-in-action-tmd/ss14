package com.rikkei.smarthub.dto.operations;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationsChatResponse {

    private String reply;
    private String trackingCode;
    private Boolean incidentCreated;
    private Long incidentId;
    private Boolean deliveryStatusUpdated;
    private String newDeliveryStatus;

    @Builder.Default
    private List<String> toolCallsExecuted = new ArrayList<>();

    private Long latencyMs;
    private Integer promptTokens;
    private Integer completionTokens;
    private Integer totalTokens;
    private String traceId;
}

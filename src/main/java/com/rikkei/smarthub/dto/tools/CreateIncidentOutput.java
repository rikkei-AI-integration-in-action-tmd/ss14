package com.rikkei.smarthub.dto.tools;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateIncidentOutput {

    private boolean success;
    private Long incidentId;
    private String trackingCode;
    private String message;
    private String errorCode;

    public static CreateIncidentOutput ok(Long incidentId, String trackingCode, String message) {
        return CreateIncidentOutput.builder()
                .success(true)
                .incidentId(incidentId)
                .trackingCode(trackingCode)
                .message(message)
                .build();
    }

    public static CreateIncidentOutput error(String errorCode, String message) {
        return CreateIncidentOutput.builder()
                .success(false)
                .errorCode(errorCode)
                .message(message)
                .build();
    }
}

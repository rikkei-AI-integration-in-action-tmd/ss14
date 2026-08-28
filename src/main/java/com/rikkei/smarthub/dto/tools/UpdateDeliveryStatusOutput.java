package com.rikkei.smarthub.dto.tools;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDeliveryStatusOutput {

    private boolean success;
    private String trackingCode;
    private String previousStatus;
    private String currentStatus;
    private String message;
    private String errorCode;

    public static UpdateDeliveryStatusOutput ok(String trackingCode, String prev, String current, String message) {
        return UpdateDeliveryStatusOutput.builder()
                .success(true)
                .trackingCode(trackingCode)
                .previousStatus(prev)
                .currentStatus(current)
                .message(message)
                .build();
    }

    public static UpdateDeliveryStatusOutput error(String errorCode, String message) {
        return UpdateDeliveryStatusOutput.builder()
                .success(false)
                .errorCode(errorCode)
                .message(message)
                .build();
    }
}

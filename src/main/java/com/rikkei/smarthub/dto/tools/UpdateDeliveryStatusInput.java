package com.rikkei.smarthub.dto.tools;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public record UpdateDeliveryStatusInput(
        @JsonProperty(required = true)
        @JsonPropertyDescription("Mã vận đơn cần cập nhật trạng thái (Ví dụ: RK-2026-001)")
        String trackingCode,

        @JsonProperty(required = true)
        @JsonPropertyDescription("Trạng thái vận chuyển mới: IN_TRANSIT, DELIVERED, DELAYED, hoặc DAMAGED")
        String status,

        @JsonPropertyDescription("Lý do hoặc ghi chú cập nhật trạng thái")
        String reason
) {}

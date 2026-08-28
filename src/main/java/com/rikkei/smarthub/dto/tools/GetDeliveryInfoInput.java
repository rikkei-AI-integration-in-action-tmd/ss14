package com.rikkei.smarthub.dto.tools;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public record GetDeliveryInfoInput(
        @JsonProperty(required = true)
        @JsonPropertyDescription("Mã vận đơn cần tra cứu thông tin (Ví dụ: RK-2026-001)")
        String trackingCode
) {}

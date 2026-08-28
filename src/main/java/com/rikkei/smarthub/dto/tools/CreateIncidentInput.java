package com.rikkei.smarthub.dto.tools;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public record CreateIncidentInput(
        @JsonProperty(required = true)
        @JsonPropertyDescription("Mã vận đơn xảy ra sự cố (Ví dụ: RK-2026-001)")
        String trackingCode,

        @JsonProperty(required = true)
        @JsonPropertyDescription("Loại sự cố: HỎNG_HÓC, GIAO_TRỄ, hoặc THẤT_LẠC")
        String incidentType,

        @JsonProperty(required = true)
        @JsonPropertyDescription("Mã bưu cục hoặc kho xử lý nơi xảy ra sự cố (Ví dụ: HN-01, SG-02, DN-03)")
        String hubCode,

        @JsonProperty(required = true)
        @JsonPropertyDescription("Mức độ nghiêm trọng của sự cố: LOW, MEDIUM, hoặc CRITICAL")
        String severity,

        @JsonProperty(required = true)
        @JsonPropertyDescription("Mô tả chi tiết nội dung sự cố do khách hàng phản ánh")
        String description
) {}

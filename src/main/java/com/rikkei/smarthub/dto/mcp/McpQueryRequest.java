package com.rikkei.smarthub.dto.mcp;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class McpQueryRequest {

    @NotBlank(message = "Yêu cầu phân tích/truy vấn không được để trống")
    private String query;

    private String hubCode;
    private String timeRange;
}

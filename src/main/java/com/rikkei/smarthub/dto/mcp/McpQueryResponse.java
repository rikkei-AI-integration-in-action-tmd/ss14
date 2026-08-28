package com.rikkei.smarthub.dto.mcp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class McpQueryResponse {

    private String markdownReport;
    private String executedSql;
    private Integer rowCount;
    private List<Map<String, Object>> data;
    private Long latencyMs;
    private String traceId;
}

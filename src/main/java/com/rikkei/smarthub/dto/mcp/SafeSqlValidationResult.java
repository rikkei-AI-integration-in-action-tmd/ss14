package com.rikkei.smarthub.dto.mcp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SafeSqlValidationResult {

    private boolean valid;
    private String sanitizedSql;
    private String reason;
    private String violationType;
}

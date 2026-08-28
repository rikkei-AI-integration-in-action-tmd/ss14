package com.rikkei.smarthub.dto.rag;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentIngestResponse {

    private boolean success;
    private String documentName;
    private int totalChunks;
    private String message;
}

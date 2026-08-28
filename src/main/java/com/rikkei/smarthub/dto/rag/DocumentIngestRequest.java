package com.rikkei.smarthub.dto.rag;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentIngestRequest {

    private String documentPath;
    private String documentName;

    @Builder.Default
    private int chunkSize = 500;

    @Builder.Default
    private int chunkOverlap = 50;
}

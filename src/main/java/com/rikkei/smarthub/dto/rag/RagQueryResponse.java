package com.rikkei.smarthub.dto.rag;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RagQueryResponse {

    private String answer;

    @Builder.Default
    private List<SourceDocumentDto> sourceDocuments = new ArrayList<>();

    private Long latencyMs;
    private Integer promptTokens;
    private Integer completionTokens;
    private Integer totalTokens;
    private String traceId;
}

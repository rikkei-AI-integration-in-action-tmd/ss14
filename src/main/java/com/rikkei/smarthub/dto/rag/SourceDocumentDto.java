package com.rikkei.smarthub.dto.rag;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SourceDocumentDto {

    private String documentName;
    private String pageOrClause;
    private String snippet;
    private Double similarityScore;
    private Map<String, Object> metadata;
}

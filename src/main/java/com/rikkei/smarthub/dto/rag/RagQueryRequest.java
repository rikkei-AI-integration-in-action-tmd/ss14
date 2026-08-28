package com.rikkei.smarthub.dto.rag;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RagQueryRequest {

    @NotBlank(message = "Câu hỏi tra cứu không được để trống")
    private String question;

    @Builder.Default
    private int topK = 4;

    @Builder.Default
    private Double similarityThreshold = 0.7;

    private String filterCategory;
}

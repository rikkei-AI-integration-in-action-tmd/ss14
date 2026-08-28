package com.rikkei.smarthub.dto.llmops;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LangfuseScoreRequest {

    @NotBlank(message = "traceId không được để trống")
    private String traceId;

    @NotBlank(message = "Tên tiêu chí đánh giá (score name) không được để trống")
    private String name;

    @NotNull(message = "Điểm đánh giá (value) không được để trống")
    private Double value;

    private String comment;
}

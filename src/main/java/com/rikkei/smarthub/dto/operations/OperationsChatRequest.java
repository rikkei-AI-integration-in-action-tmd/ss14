package com.rikkei.smarthub.dto.operations;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationsChatRequest {

    @NotBlank(message = "Nội dung tin nhắn không được để trống")
    private String message;

    private String sessionId;
    private String customerId;
}

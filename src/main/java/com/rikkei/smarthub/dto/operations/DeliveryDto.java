package com.rikkei.smarthub.dto.operations;

import com.rikkei.smarthub.entity.enums.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDto {

    private Long id;
    private String trackingCode;
    private String customerName;
    private String hubCode;
    private DeliveryStatus status;
    private BigDecimal codAmount;
    private LocalDateTime createdAt;
}

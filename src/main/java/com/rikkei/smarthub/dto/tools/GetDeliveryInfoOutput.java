package com.rikkei.smarthub.dto.tools;

import com.rikkei.smarthub.dto.operations.DeliveryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetDeliveryInfoOutput {

    private boolean success;
    private DeliveryDto delivery;
    private String message;
    private String errorCode;

    public static GetDeliveryInfoOutput ok(DeliveryDto delivery) {
        return GetDeliveryInfoOutput.builder()
                .success(true)
                .delivery(delivery)
                .message("Tìm thấy thông tin đơn hàng")
                .build();
    }

    public static GetDeliveryInfoOutput error(String errorCode, String message) {
        return GetDeliveryInfoOutput.builder()
                .success(false)
                .errorCode(errorCode)
                .message(message)
                .build();
    }
}

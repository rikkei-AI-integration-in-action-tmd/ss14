package com.rikkei.smarthub.dto.operations;

import com.rikkei.smarthub.entity.enums.IncidentSeverity;
import com.rikkei.smarthub.entity.enums.IncidentStatus;
import com.rikkei.smarthub.entity.enums.IncidentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncidentDto {

    private Long id;
    private String trackingCode;
    private IncidentType incidentType;
    private String hubCode;
    private IncidentSeverity severity;
    private String description;
    private IncidentStatus status;
    private LocalDateTime createdAt;
}

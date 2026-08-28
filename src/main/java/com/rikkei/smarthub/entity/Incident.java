package com.rikkei.smarthub.entity;

import com.rikkei.smarthub.entity.enums.IncidentSeverity;
import com.rikkei.smarthub.entity.enums.IncidentStatus;
import com.rikkei.smarthub.entity.enums.IncidentType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "incidents", indexes = {
        @Index(name = "idx_incidents_tracking_code", columnList = "tracking_code"),
        @Index(name = "idx_incidents_hub_code", columnList = "hub_code"),
        @Index(name = "idx_incidents_status", columnList = "status")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tracking_code", nullable = false, length = 50)
    private String trackingCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "incident_type", nullable = false, length = 50)
    private IncidentType incidentType;

    @Column(name = "hub_code", nullable = false, length = 20)
    private String hubCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "severity", nullable = false, length = 20)
    private IncidentSeverity severity;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 30)
    @Builder.Default
    private IncidentStatus status = IncidentStatus.OPEN;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
        if (this.status == null) {
            this.status = IncidentStatus.OPEN;
        }
    }
}

package com.rikkei.smarthub.repository;

import com.rikkei.smarthub.entity.Incident;
import com.rikkei.smarthub.entity.enums.IncidentSeverity;
import com.rikkei.smarthub.entity.enums.IncidentStatus;
import com.rikkei.smarthub.entity.enums.IncidentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {

    List<Incident> findByTrackingCode(String trackingCode);

    List<Incident> findByHubCode(String hubCode);

    List<Incident> findByStatus(IncidentStatus status);

    List<Incident> findByIncidentType(IncidentType incidentType);

    List<Incident> findBySeverity(IncidentSeverity severity);

    long countByHubCodeAndStatus(String hubCode, IncidentStatus status);

    long countByHubCode(String hubCode);
}

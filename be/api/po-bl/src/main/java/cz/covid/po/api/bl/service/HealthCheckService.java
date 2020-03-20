package cz.covid.po.api.bl.service;

import cz.covid.po.api.domain.model.HealthCheck;
import cz.covid.po.api.domain.model.HealthCheckResult;
import java.util.UUID;

public interface HealthCheckService {
    HealthCheck update(UUID updatedPersonUid, HealthCheck source) ;

    HealthCheck addHealthCheckTestResult(UUID personUid,  HealthCheckResult result);
}

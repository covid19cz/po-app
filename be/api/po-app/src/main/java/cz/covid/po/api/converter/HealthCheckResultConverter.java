package cz.covid.po.api.converter;

import cz.covid.po.api.domain.model.HealthCheckResult;
import cz.covid.po.api.generated.dto.HealthCheckResultDto;
import org.springframework.stereotype.Component;

@Component
public class HealthCheckResultConverter extends TwoWayConverterBase<HealthCheckResult, HealthCheckResultDto> {
    @Override
    protected HealthCheckResultDto convertInternal(HealthCheckResult healthCheckResult) {
        HealthCheckResultDto result = new HealthCheckResultDto();

        result.setPositive(healthCheckResult.getResultPositive());
        result.setTestDate(healthCheckResult.getResultDate());
        result.setResultSentAt(healthCheckResult.getResultSentAt());

        return result;
    }

    @Override
    protected HealthCheckResult convertBackInternal(HealthCheckResultDto src) {
        HealthCheckResult result = new HealthCheckResult();

        result.setResultDate(src.getTestDate());
        result.setResultPositive(src.isPositive());

        return result;
    }
}

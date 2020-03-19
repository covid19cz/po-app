package cz.covid.po.api.converter;

import cz.covid.po.api.domain.model.HealthCheck;
import cz.covid.po.api.generated.dto.HealthCheckDto;
import cz.covid.po.api.generated.dto.SymptomEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HealthCheckConverter extends OneWayConverterBase<HealthCheck, HealthCheckDto> {
    private final HealthCheckResultConverter healthCheckResultConverter;
    private final CodebookConvertor codebookConvertor;

    @Override
    protected HealthCheckDto convertInternal(HealthCheck healthCheck) {
        HealthCheckDto result = new HealthCheckDto();

        result.setAbleToDrive(healthCheck.getAbleToDrive());
        if (healthCheck.getDryCoughDuration() != null) {
            result.setDryCoughDuration(SymptomEnum.fromValue(healthCheck.getDryCoughDuration().name()));
        }
        result.setFinalHealthCheckLocation(codebookConvertor.convert(healthCheck.getFinalHealthCheckLocation()));
        result.setHeadache(healthCheck.getHeadache());
        result.setHealthCheckCode(healthCheck.getHealthCheckCode());
        result.setHealthCheckType(codebookConvertor.convert(healthCheck.getHealthCheckType()));
        if (healthCheck.getHighTemperatureDuration() != null) {
            result.setHighTemperatureDuration(SymptomEnum.fromValue(healthCheck.getHighTemperatureDuration().name()));
        }
        result.setInfectedInContact(healthCheck.getInfectedInContact());
        result.setInfectedInContactDate(healthCheck.getInfectedInContactDate());
        result.setInfectedPhoneNumbers(healthCheck.getInfectedPhoneNumbers());
        result.setPreferredHealthCheckLocation(codebookConvertor.convert(healthCheck.getPreferredHealthCheckLocation()));
        result.setSymtompsSince(healthCheck.getSymtompsSince());
        result.setVisitedRiskArea(codebookConvertor.convert(healthCheck.getVisitedRiskArea()));
        result.setHealthCheckResults(healthCheckResultConverter.convert(healthCheck.getHealthCheckResults()));

        return result;
    }
}

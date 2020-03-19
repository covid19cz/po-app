package cz.covid.po.api.converter;

import cz.covid.po.api.domain.model.HealthCheck;
import cz.covid.po.api.domain.model.HealthCheckResult;
import cz.covid.po.api.generated.dto.HealthCheckDto;
import cz.covid.po.api.generated.dto.HealthCheckResultDto;
import cz.covid.po.api.generated.dto.SymptomEnum;
import lombok.RequiredArgsConstructor;
import org.bouncycastle.asn1.sec.SECNamedCurves;
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
        result.setDryCoughDuration(SymptomEnum.fromValue(healthCheck.getDryCoughDuration().name()));
        result.setFinalHealthCheckLocation(codebookConvertor.convertInternal(healthCheck.getFinalHealthCheckLocation()));
        result.setHeadache(healthCheck.getHeadache());
        result.setHealthCheckCode(healthCheck.getHealthCheckCode());
        result.setHealthCheckType(codebookConvertor.convertInternal(healthCheck.getHealthCheckType()));
        result.setHighTemperatureDuration(SymptomEnum.fromValue(healthCheck.getHighTemperatureDuration().name()));
        result.setInfectedInContact(healthCheck.getInfectedInContact());
        result.setInfectedInContactDate(healthCheck.getInfectedInContactDate());
        result.setInfectedPhoneNumbers(healthCheck.getInfectedPhoneNumbers());
        result.setPreferredHealthCheckLocation(codebookConvertor.convertInternal(healthCheck.getPreferredHealthCheckLocation()));
        result.setSymtompsSince(healthCheck.getSymtompsSince());
        result.setVisitedRiskArea(codebookConvertor.convertInternal(healthCheck.getVisitedRiskArea()));
        result.setHealthCheckResults(healthCheckResultConverter.convert(healthCheck.getHealthCheckResults()));

        return result;
    }
}

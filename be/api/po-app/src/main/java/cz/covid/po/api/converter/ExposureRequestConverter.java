package cz.covid.po.api.converter;

import cz.covid.po.api.domain.model.HealthCheck;
import cz.covid.po.api.domain.repository.codebook.CbRiskAreaRepository;
import cz.covid.po.api.generated.dto.ExposureRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExposureRequestConverter extends OneWayConverterBase<ExposureRequest, HealthCheck> {
    private final CbRiskAreaRepository cbRiskAreaRepository;

    @Override
    protected HealthCheck convertInternal(ExposureRequest source) {
        HealthCheck result = new HealthCheck();
        result.setInfectedInContact(source.getInfectedInContact().toString());
        result.setInfectedPhoneNumbers(source.getInfectedPhoneNumbers());
        result.setInfectedInContactDate(source.getInfectedInContactDate());

        if (source.getVisitedRiskArea() != null) {
            result.setVisitedRiskArea(cbRiskAreaRepository.getOne(source.getVisitedRiskArea().getCode()));
        }

        return result;
    }
}

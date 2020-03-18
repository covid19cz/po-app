package cz.covid.po.api.converter;

import cz.covid.po.api.domain.model.HealthCheck;
import cz.covid.po.api.domain.repository.codebook.CbHealthCheckLocationRepository;
import cz.covid.po.api.generated.dto.TestingPlaceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestingPlaceRequestConverter extends OneWayConverterBase<TestingPlaceRequest, HealthCheck> {
    private final CbHealthCheckLocationRepository cbHealthCheckLocationRepository;

    @Override
    protected HealthCheck convertInternal(TestingPlaceRequest source) {
        HealthCheck result = new HealthCheck();

        if (source.getPreferredHealthCheckLocation() != null) {
            result.setPreferredHealthCheckLocation(cbHealthCheckLocationRepository.getOne(source.getPreferredHealthCheckLocation().getCode()));
        }

        result.setAbleToDrive(source.isAbleToDrive());

        return result;
    }
}

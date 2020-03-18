package cz.covid.po.api.converter;

import cz.covid.po.api.domain.model.HealthCheck;
import cz.covid.po.api.generated.dto.SimtompsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SimtompsRequestConverter extends OneWayConverterBase<SimtompsRequest, HealthCheck> {
    @Override
    protected HealthCheck convertInternal(SimtompsRequest source) {
        HealthCheck result = new HealthCheck();

        result.setDryCoughDuration(source.getDryCoughDuration());
        result.setHighTemperatureDuration(source.getHighTemperatureDuration());
        result.setSymtompsSince(source.getSymtompsSince());

        return result;
    }
}

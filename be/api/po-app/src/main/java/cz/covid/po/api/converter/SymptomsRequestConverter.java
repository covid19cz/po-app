package cz.covid.po.api.converter;

import cz.covid.po.api.domain.model.HealthCheck;
import cz.covid.po.api.domain.model.enumeration.SymptomsEnum;
import cz.covid.po.api.generated.dto.SimtompsRequest;
import cz.covid.po.api.generated.dto.SymptomsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SymptomsRequestConverter extends OneWayConverterBase<SymptomsRequest, HealthCheck> {
    @Override
    protected HealthCheck convertInternal(SymptomsRequest source) {
        HealthCheck result = new HealthCheck();

        result.setDryCoughDuration(SymptomsEnum.findByName(source.getDryCoughDuration().name()).orElse(null));
        result.setHighTemperatureDuration(SymptomsEnum.findByName(source.getHighTemperatureDuration().name()).orElse(null));
        result.setHeadache(source.isHeadache());
        result.setSymtompsSince(source.getSymtomsSince());

        return result;
    }
}

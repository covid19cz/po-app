package cz.covid.po.api.controller;

import cz.covid.po.api.bl.service.HealthCheckService;
import cz.covid.po.api.converter.ExposureRequestConverter;
import cz.covid.po.api.converter.SymptomsRequestConverter;
import cz.covid.po.api.converter.TestingPlaceRequestConverter;
import cz.covid.po.api.generated.controller.HealthCheckControllerApi;
import cz.covid.po.api.generated.dto.ExposureRequest;
import cz.covid.po.api.generated.dto.SymptomsRequest;
import cz.covid.po.api.generated.dto.TestingPlaceInstuctionsDto;
import cz.covid.po.api.generated.dto.TestingPlaceRequest;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HealthCheckController extends ControllerBase implements HealthCheckControllerApi {
    private final HealthCheckService healthCheckService;
    private final ExposureRequestConverter exposureRequestConverter;
    private final SymptomsRequestConverter symtomsRequestConverter;
    private final TestingPlaceRequestConverter testingPlaceRequestConverter;

    @Override
    public ResponseEntity<Void> personsPersonUidHealthCheckExposurePut(UUID personUid, ExposureRequest exposureDto) {
        healthCheckService.update(personUid, exposureRequestConverter.convert(exposureDto));
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> personsPersonUidHealthCheckSymptomsPut(UUID personUid, SymptomsRequest symptomsRequest) {

        healthCheckService.update(personUid, symtomsRequestConverter.convert(symptomsRequest));
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<TestingPlaceInstuctionsDto> personsPersonUidHealthCheckTestingPlacePut(UUID personUid, TestingPlaceRequest testingPlaceDto) {
        healthCheckService.update(personUid, testingPlaceRequestConverter.convert(testingPlaceDto));
        return ResponseEntity.noContent().build();
    }
}

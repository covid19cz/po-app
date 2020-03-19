package cz.covid.po.api.controller;

import cz.covid.po.api.bl.service.HealthCheckService;
import cz.covid.po.api.converter.ExposureRequestConverter;
import cz.covid.po.api.converter.HealthCheckConverter;
import cz.covid.po.api.converter.HealthCheckResultConverter;
import cz.covid.po.api.converter.SymptomsRequestConverter;
import cz.covid.po.api.converter.TestingPlaceRequestConverter;
import cz.covid.po.api.domain.model.HealthCheckResult;
import cz.covid.po.api.generated.controller.HealthCheckControllerApi;
import cz.covid.po.api.generated.dto.ExposureRequest;
import cz.covid.po.api.generated.dto.HealthCheckDto;
import cz.covid.po.api.generated.dto.HealthCheckResultDto;
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
    private final HealthCheckConverter healthCheckConverter;
    private final HealthCheckResultConverter healthCheckResultConverter;
    private final SymptomsRequestConverter symptomsRequestConverter;
    private final TestingPlaceRequestConverter testingPlaceRequestConverter;

    @Override
    public ResponseEntity<Void> putHealthCheckExposure(UUID personUid, ExposureRequest exposureDto) {
        healthCheckService.update(personUid, exposureRequestConverter.convert(exposureDto));
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> putHealthCheckSymptoms(UUID personUid, SymptomsRequest symptomsRequest) {

        healthCheckService.update(personUid, symptomsRequestConverter.convert(symptomsRequest));
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<TestingPlaceInstuctionsDto> putHealthCheckTestingPlace(UUID personUid, TestingPlaceRequest testingPlaceDto) {
        healthCheckService.update(personUid, testingPlaceRequestConverter.convert(testingPlaceDto));
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<HealthCheckDto> postHeathCheckTestResult(UUID personUid, Long healthCheckId, HealthCheckResultDto testResultDto) {
        HealthCheckResult result = healthCheckResultConverter.convertBack(testResultDto);

        return ResponseEntity.ok(healthCheckConverter.convert(healthCheckService.addHealthCheckTestResult(personUid, healthCheckId, result)));
    }
}

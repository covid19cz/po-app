package cz.covid.po.api.controller;

import cz.covid.po.api.bl.service.HealthCheckService;
import cz.covid.po.api.converter.ExposureRequestConverter;
import cz.covid.po.api.converter.SimtompsRequestConverter;
import cz.covid.po.api.converter.TestingPlaceRequestConverter;
import cz.covid.po.api.domain.model.enumeration.AuthRole;
import cz.covid.po.api.generated.controller.HealthCheckControllerApi;
import cz.covid.po.api.generated.dto.ExposureRequest;
import cz.covid.po.api.generated.dto.SimtompsRequest;
import cz.covid.po.api.generated.dto.TestingPlaceInstuctionsDto;
import cz.covid.po.api.generated.dto.TestingPlaceRequest;
import java.util.UUID;
import javax.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HealthCheckController extends ControllerBase implements HealthCheckControllerApi {
    private final HealthCheckService healthCheckService;
    private final ExposureRequestConverter exposureRequestConverter;
    private final SimtompsRequestConverter simtompsRequestConverter;
    private final TestingPlaceRequestConverter testingPlaceRequestConverter;

    @Override
    public ResponseEntity<Void> personsPersonUidHealthCheckExposurePut(UUID personUid, ExposureRequest exposureDto) {
        healthCheckService.update(personUid, exposureRequestConverter.convert(exposureDto));
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> personsPersonUidHealthCheckSymptomsPut(UUID personUid, SimtompsRequest simptomsDto) {

        healthCheckService.update(personUid, simtompsRequestConverter.convert(simptomsDto));
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<TestingPlaceInstuctionsDto> personsPersonUidHealthCheckTestingPlacePut(UUID personUid, TestingPlaceRequest testingPlaceDto) {
        healthCheckService.update(personUid, testingPlaceRequestConverter.convert(testingPlaceDto));
        return ResponseEntity.noContent().build();
    }
}

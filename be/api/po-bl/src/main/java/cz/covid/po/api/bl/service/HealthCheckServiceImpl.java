package cz.covid.po.api.bl.service;

import cz.covid.po.api.bl.util.PatchUtil;
import cz.covid.po.api.domain.model.HealthCheck;
import cz.covid.po.api.domain.repository.HealthCheckRepository;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HealthCheckServiceImpl implements HealthCheckService {
    private final HealthCheckRepository healthCheckRepository;
    private final PersonService personService;

    @Override
    public HealthCheck update(UUID updatedPersonUid, HealthCheck source) {
        HealthCheck target = getOrCreate(updatedPersonUid);

        PatchUtil.callIfNotNull(source.getAbleToDrive(), target::setAbleToDrive);
        PatchUtil.callIfNotNull(source.getDryCoughDuration(), target::setDryCoughDuration);
        PatchUtil.callIfNotNull(source.getHeadache(), target::setHeadache);
        PatchUtil.callIfNotNull(source.getHighTemperatureDuration(), target::setHighTemperatureDuration);
        PatchUtil.callIfNotNull(source.getInfectedInContact(), target::setInfectedInContact);
        PatchUtil.callIfNotNull(source.getInfectedInContactDate(), target::setInfectedInContactDate);
        PatchUtil.callIfNotNull(source.getInfectedPhoneNumbers(), target::setInfectedPhoneNumbers);
        PatchUtil.callIfNotNull(source.getSymtompsSince(), target::setSymtompsSince);
        PatchUtil.callIfNotNull(source.getVisitedRiskArea(), target::setVisitedRiskArea);
        PatchUtil.callIfNotNull(source.getPreferredHealthCheckLocation(), target::setPreferredHealthCheckLocation);

        return healthCheckRepository.save(target);
    }

    HealthCheck getOrCreate(UUID personUid) {
        Optional<HealthCheck> person = healthCheckRepository.getByPersonUid(personUid);
        return person.orElseGet(() -> createHealthCheck(personUid));
    }

    private HealthCheck createHealthCheck(UUID personUid) {
        HealthCheck healthCheck = new HealthCheck();

        healthCheck.setPerson(personService.getByUid(personUid));

        return healthCheck;
    }
}

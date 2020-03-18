package cz.covid.po.api.scheduler;

import cz.covid.po.api.bl.util.DateTimeUtil;
import cz.covid.po.api.domain.model.HealthCheckResult;
import cz.covid.po.api.domain.repository.HealthCheckResultRepository;
import cz.covid.po.api.integration.common.exception.IntegrationException;
import cz.covid.po.api.integration.profisms.service.ProfiSmsSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ResultSendingScheduler {

    @Autowired
    HealthCheckResultRepository healthCheckResultRepository;

    @Autowired
    ProfiSmsSender profiSmsSender;

    @Scheduled(cron = "${api.scheduler.cron}")
    public void sendResults() {
        List<HealthCheckResult> allNotSentYet = healthCheckResultRepository.findAllByResultSentAtIsNull();
        log.info("Number of SMS to be sent: {}",allNotSentYet.size());
        for (HealthCheckResult healtCheckResult:allNotSentYet) {
            String phoneNumber = healtCheckResult.getHealthCheck().getPerson().getPhoneNumber();
            try {
                profiSmsSender.sendSms(phoneNumber, "Vysledek vaseho testu je: " + healtCheckResult.getResultPositive());
                healtCheckResult.setResultSentAt(DateTimeUtil.utc());
                healthCheckResultRepository.save(healtCheckResult);
            } catch (IntegrationException ie) {
                log.trace("Problem occured while sending SMS to {}", phoneNumber, ie);
            }
        }
    }

}

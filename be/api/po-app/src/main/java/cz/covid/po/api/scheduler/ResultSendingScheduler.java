package cz.covid.po.api.scheduler;

import cz.covid.po.api.domain.model.HealtCheckResult;
import cz.covid.po.api.domain.repository.HealthCheckResultRepository;
import cz.covid.po.api.integration.profisms.service.ProfiSmsSender;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.List;

@Log
@Component
public class ResultSendingScheduler {

    @Autowired
    HealthCheckResultRepository healthCheckResultRepository;

    @Autowired
    ProfiSmsSender profiSmsSender;

    @Scheduled(cron = "${api.scheduler.cron}")
    public void sendResults() {
        log.info("result sending scheduler running...");
        List<HealtCheckResult> allNotSentYet = healthCheckResultRepository.findAllByResultSentAtIsNull();
        for (HealtCheckResult healtCheckResult:allNotSentYet) {
            String phoneNumber = healtCheckResult.getHealthCheck().getPerson().getPhoneNumber();
            profiSmsSender.sendSms(phoneNumber, "Vysledek vaseho testu je: " + healtCheckResult.getResultPositive());
            healtCheckResult.setResultSentAt(OffsetDateTime.now());
            healthCheckResultRepository.save(healtCheckResult);
        }
    }

}

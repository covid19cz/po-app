package cz.covid.po.api.scheduler;

import cz.covid.po.api.bl.util.DateTimeUtil;
import cz.covid.po.api.domain.model.HealthCheckResult;
import cz.covid.po.api.domain.repository.HealthCheckResultRepository;
import cz.covid.po.api.integration.common.exception.IntegrationException;
import cz.covid.po.api.integration.profisms.service.ProfiSmsSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j2
@Component
@RequiredArgsConstructor
public class ResultSendingScheduler {

    @Autowired
    private final HealthCheckResultRepository healthCheckResultRepository;

    @Autowired
    private final ProfiSmsSender profiSmsSender;

    @Scheduled(cron = "${api.scheduler.cron}")
    public void sendResults() {
        List<HealthCheckResult> allNotSentYet = healthCheckResultRepository.findAllByResultSentAtIsNull();
        log.info("Number of SMS to be sent: {}",allNotSentYet.size());
        for (HealthCheckResult healtCheckResult:allNotSentYet) {
            String phoneNumber = healtCheckResult.getHealthCheck().getPerson().getPhoneNumber();
            try {
                String message;
                if (healtCheckResult.getResultPositive() == Boolean.TRUE) {
                    message = "Dobrý den. Výsledky vašeho testu na Covid19 jsou bohužel pozitivní. V nejbližší době vás bude kontaktovat zástupce hygienické stanice a dohodne s vámi další postup. Zároveň vás prosíme o spolupráci a na https://covid19.cz/r/dhjB28HH prosím vyplňte doplňující informace, abychom zabránili dalšímu šíření nemoci.";
                } else {
                    message = "Dobrý den. Výsledky vašeho testu na Covid19 jsou negativní, nejste nakažen/a. Výsledek testu naleznete na https://covid19.cz/r/dhjB28HH";
                }
                profiSmsSender.sendSms(phoneNumber, "Vysledek vaseho testu je: " + healtCheckResult.getResultPositive());
                healtCheckResult.setResultSentAt(DateTimeUtil.utc());
                healthCheckResultRepository.save(healtCheckResult);
            } catch (IntegrationException ie) {
                log.warn("Problem occured while sending SMS to {}", phoneNumber, ie);
            }
        }
    }

}

package cz.covid.po.api.scheduler;

import cz.covid.po.api.domain.model.HealtCheckResult;
import cz.covid.po.api.domain.repository.HealthCheckResultRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Log
@Component
public class ResultSendingScheduler {

    @Autowired
    HealthCheckResultRepository healthCheckResultRepository;

    @Scheduled(cron = "${api.scheduler.cron}")
    public void sendResults() {
        log.info("result sending scheduler running...");
        List<HealtCheckResult> allNotSentYet = healthCheckResultRepository.findAllByResultSentAtIsNull();
        // TODO: send SMS
        // TODO: update all
        System.out.println();
    }

}

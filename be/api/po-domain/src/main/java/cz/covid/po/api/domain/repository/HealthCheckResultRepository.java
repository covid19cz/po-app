package cz.covid.po.api.domain.repository;

import cz.covid.po.api.domain.model.HealthCheckResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthCheckResultRepository extends JpaRepository<HealthCheckResult, Long> {

    List<HealthCheckResult> findAllByResultSentAtIsNull();

}

package cz.covid.po.api.domain.repository;

import cz.covid.po.api.domain.model.Address;
import cz.covid.po.api.domain.model.HealtCheckResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthCheckResultRepository extends JpaRepository<HealtCheckResult, Long> {

    List<HealtCheckResult> findAllByResultSentAtIsNull();

}

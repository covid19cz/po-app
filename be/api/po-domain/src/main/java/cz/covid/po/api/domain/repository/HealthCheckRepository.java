package cz.covid.po.api.domain.repository;

import cz.covid.po.api.domain.model.HealthCheck;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthCheckRepository extends JpaRepository<HealthCheck, Long> {
    Optional<HealthCheck> getByPersonUid(UUID personUid);
}

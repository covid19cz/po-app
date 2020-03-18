package cz.covid.po.api.domain.repository;

import cz.covid.po.api.domain.model.Operator;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorRepository extends JpaRepository<Operator, Long> {

    Optional<Operator> findByUserId(Long userId);

}

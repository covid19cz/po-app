package cz.covid.po.api.repository;

import cz.covid.po.api.model.jpa.RiskyAreaVisit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiskyAreaVisitRepository extends JpaRepository<RiskyAreaVisit, Long> {
}

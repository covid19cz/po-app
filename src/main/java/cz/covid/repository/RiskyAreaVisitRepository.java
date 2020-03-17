package cz.covid.repository;

import cz.covid.model.jpa.RiskyAreaVisit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiskyAreaVisitRepository extends JpaRepository<RiskyAreaVisit, Long> {
}

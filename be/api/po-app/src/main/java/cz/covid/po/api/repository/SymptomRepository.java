package cz.covid.po.api.repository;

import cz.covid.po.api.model.jpa.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SymptomRepository extends JpaRepository<Symptom, Long> {
}

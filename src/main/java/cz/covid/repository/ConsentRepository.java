package cz.covid.repository;

import cz.covid.model.jpa.Consent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsentRepository extends JpaRepository<Consent, Long> {

    List<Consent> findByPerson_Id(Long personId);
}

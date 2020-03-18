package cz.covid.po.api.domain.repository;

import cz.covid.po.api.domain.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

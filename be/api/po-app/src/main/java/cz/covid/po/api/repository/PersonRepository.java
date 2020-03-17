package cz.covid.po.api.repository;

import cz.covid.po.api.model.jpa.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

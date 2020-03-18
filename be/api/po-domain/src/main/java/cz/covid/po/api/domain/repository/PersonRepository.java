package cz.covid.po.api.domain.repository;

import cz.covid.po.api.domain.model.Person;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> getByPhoneNumber(String phoneNumber);

    Optional<Person> getByUid(UUID personUid);
}

package cz.covid.po.api.bl.service;

import cz.covid.po.api.domain.model.Person;
import java.util.UUID;

public interface PersonService {
    Person getOrCreate(String phoneNumber);

    Person getByUid(UUID personUid);

    Person update(UUID updatedPersonUid, Person source);
}

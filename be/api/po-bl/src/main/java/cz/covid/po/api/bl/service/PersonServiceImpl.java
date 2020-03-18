package cz.covid.po.api.bl.service;

import cz.covid.po.api.bl.exception.NotFoundException;
import cz.covid.po.api.bl.util.DateTimeUtil;
import cz.covid.po.api.bl.util.PatchUtil;
import cz.covid.po.api.domain.model.Address;
import cz.covid.po.api.domain.model.Person;
import cz.covid.po.api.domain.model.codebook.CbHealthStatus;
import cz.covid.po.api.domain.repository.PersonRepository;
import cz.covid.po.api.domain.repository.codebook.CbHealthStatusRepository;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final CbHealthStatusRepository cbHealthStatusRepository;
    private final PersonRepository personRepository;

    @Override
    public Person getOrCreate(String phoneNumber) {
        Optional<Person> person = personRepository.getByPhoneNumber(phoneNumber);
        return person.orElseGet(() -> createPerson(phoneNumber));
    }

    @Override
    public Person getByUid(UUID personUid) {
        return personRepository
                .getByUid(personUid)
                .orElseThrow(() -> new NotFoundException(NotFoundException.createSystemMessage("uid", personUid, Person.class)));
    }

    @Override
    public Person update(UUID updatedPersonUid, Person source) {
        Person target = getByUid(updatedPersonUid);

        PatchUtil.callIfNotNull(source.getEmail(), target::setEmail);
        PatchUtil.callIfNotNull(source.getFirstName(), target::setFirstName);
        PatchUtil.callIfNotNull(source.getSurname(), target::setSurname);
        PatchUtil.callIfNotNull(source.getHealthStatus(), target::setHealthStatus);
        PatchUtil.callIfNotNull(source.getAddress(), (value) -> this.updatePersonAddress(target, value));

        return personRepository.save(target);
    }

    private <T> void updatePersonAddress(Person person, Address source) {
        if (person.getAddress() == null) {
            person.setAddress(new Address());
        }

        Address target = person.getAddress();
        target.setCity(source.getCity());
        target.setNumberDescriptive(source.getNumberDescriptive());
        target.setNumberEvidence(source.getNumberEvidence());
        target.setStreet(source.getStreet());
        target.setZipCode(source.getZipCode());
    }

    private Person createPerson(String phoneNumber) {
        Person person = new Person();
        person.setUid(UUID.randomUUID());

        person.setPhoneNumber(phoneNumber);
        person.setHealthStatus(cbHealthStatusRepository.getOne(CbHealthStatus.Items.UNKNOWN));
        person.setHealthStatusLastChange(DateTimeUtil.utc());

        personRepository.save(person);

        return person;
    }
}

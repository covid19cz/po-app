package cz.covid.service;

import cz.covid.model.dto.ConsentDto;
import cz.covid.model.jpa.Consent;
import cz.covid.model.jpa.Person;

import java.util.List;

public interface ConsentService {

    Consent createConsentInternal(ConsentDto consentDto, Person person);

    Consent updateConsentInternal(ConsentDto consentDto);

    List<ConsentDto> findConsentsPerson(Long personId);

    void deleteConsentInternal(Long id);

    ConsentDto mapToConsentDto(Consent consent);
}

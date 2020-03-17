package cz.covid.po.api.service;

import cz.covid.po.api.model.dto.ConsentDto;
import cz.covid.po.api.model.jpa.Consent;
import cz.covid.po.api.model.jpa.Person;

import java.util.List;

public interface ConsentService {

    Consent createConsentInternal(ConsentDto consentDto, Person person);

    Consent updateConsentInternal(ConsentDto consentDto);

    List<ConsentDto> findConsentsPerson(Long personId);

    void deleteConsentInternal(Long id);

    ConsentDto mapToConsentDto(Consent consent);
}

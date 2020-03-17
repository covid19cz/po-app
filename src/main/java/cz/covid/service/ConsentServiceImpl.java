package cz.covid.service;

import cz.covid.model.dto.ConsentDto;
import cz.covid.model.en.CodebookName;
import cz.covid.model.exception.NotFoundException;
import cz.covid.model.jpa.Consent;
import cz.covid.model.jpa.Person;
import cz.covid.model.jpa.cb.ConsentType;
import cz.covid.repository.ConsentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConsentServiceImpl implements ConsentService {

    private ConsentRepository consentRepository;
    private CodebookService codebookService;

    @Autowired
    public ConsentServiceImpl(ConsentRepository consentRepository, CodebookService codebookService) {
        this.consentRepository = consentRepository;
        this.codebookService = codebookService;
    }

    @Transactional
    public Consent createConsentInternal(ConsentDto consentDto, Person person) {
        this.validate(consentDto);
        Consent consent = this.mapToConsent(consentDto);
        consent.setCreatedAt(new Date());
        consent.setConsentType(this.codebookService.getCodebookReference(CodebookName.CONSENT_TYPE, consentDto.getId(), ConsentType.class));
        consent.setPerson(person);
        return this.consentRepository.save(consent);
    }

    @Override
    public Consent updateConsentInternal(ConsentDto consentDto) {
        this.validate(consentDto);
        Consent consent = this.findInternal(consentDto.getId());
        this.mapToConsent(consentDto, consent);
        consent.setModifiedAt(new Date());
        consent.setConsentType(this.codebookService.getCodebookReference(CodebookName.CONSENT_TYPE, consentDto.getId(), ConsentType.class));
        return this.consentRepository.save(consent);
    }

    @Override
    public List<ConsentDto> findConsentsPerson(Long personId) {
        return this.consentRepository.findByPerson_Id(personId)
                .stream()
                .map(this::mapToConsentDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteConsentInternal(Long id) {
        this.consentRepository.deleteById(id);
    }

    private Consent findInternal(Long id) {
        return this.consentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("consent for given id could not be found"));
    }

    private void validate(ConsentDto consentDto) {
        Assert.notNull(consentDto.getConsentType().getId(), "consent.consentType.id cannot be null");
    }

    @Override
    public ConsentDto mapToConsentDto(Consent consent) {
        ConsentDto consentDto = new ConsentDto();
        BeanUtils.copyProperties(consent, consentDto, "id", "consentType");
        if (consent.getConsentType() != null) {
            consentDto.setConsentType(this.codebookService.mapToCodebookValueDto(consent.getConsentType()));
        }
        return consentDto;
    }

    private Consent mapToConsent(ConsentDto consentDto) {
        return this.mapToConsent(consentDto, new Consent());
    }

    private Consent mapToConsent(ConsentDto consentDto, Consent consent) {
        BeanUtils.copyProperties(consentDto, consent, "id", "consentType");
        return consent;
    }

}

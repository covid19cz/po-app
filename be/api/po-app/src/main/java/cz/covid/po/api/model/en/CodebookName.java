package cz.covid.po.api.model.en;

import cz.covid.po.api.model.jpa.cb.*;
import cz.covid.po.api.model.jpa.cb.CodebookValue;
import cz.covid.po.api.model.jpa.cb.Comorbidity;
import cz.covid.po.api.model.jpa.cb.ConsentType;
import cz.covid.po.api.model.jpa.cb.Gender;
import cz.covid.po.api.model.jpa.cb.Nationality;
import cz.covid.po.api.model.jpa.cb.Organization;
import cz.covid.po.api.model.jpa.cb.SymptomType;
import cz.covid.po.api.model.jpa.cb.TestResult;
import cz.covid.po.api.model.jpa.cb.TestType;
import cz.covid.po.api.repository.cb.CodebookValueRepository;
import cz.covid.po.api.repository.cb.ComorbidityRepository;
import cz.covid.po.api.repository.cb.ConsentTypeRepository;
import cz.covid.po.api.repository.cb.GenderRepository;
import cz.covid.po.api.repository.cb.NationalityRepository;
import cz.covid.po.api.repository.cb.OrganizationRepository;
import cz.covid.po.api.repository.cb.SymptomTypeRepository;
import cz.covid.po.api.repository.cb.TestResultRepository;
import cz.covid.po.api.repository.cb.TestTypeRepository;
import cz.covid.po.api.repository.cb.*;

public enum CodebookName {

    COMORBIDITY(Comorbidity.class, ComorbidityRepository.class),
    CONSENT_TYPE(ConsentType.class, ConsentTypeRepository.class),
    GENDER(Gender.class, GenderRepository.class),
    NATIONALITY(Nationality.class, NationalityRepository.class),
    ORGANIZATION(Organization.class, OrganizationRepository.class),
    SYMPTOM_TYPE(SymptomType.class, SymptomTypeRepository.class),
    TEST_RESULT(TestResult.class, TestResultRepository.class),
    TEST_TYPE(TestType.class, TestTypeRepository.class);


    Class<? extends CodebookValue> clazz;
    Class<? extends CodebookValueRepository> repositoryClazz;

    CodebookName(Class<? extends CodebookValue> clazz, Class<? extends CodebookValueRepository> repositoryClazz) {
        this.clazz = clazz;
        this.repositoryClazz = repositoryClazz;
    }

    public Class<? extends CodebookValue> getClazz() {
        return clazz;
    }

    public Class<? extends CodebookValueRepository> getRepositoryClazz() {
        return repositoryClazz;
    }
}

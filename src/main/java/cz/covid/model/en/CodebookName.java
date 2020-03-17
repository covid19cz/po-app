package cz.covid.model.en;

import cz.covid.model.jpa.cb.*;
import cz.covid.repository.cb.*;

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

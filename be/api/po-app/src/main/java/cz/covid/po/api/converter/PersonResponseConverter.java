package cz.covid.po.api.converter;

import cz.covid.po.api.domain.model.Person;
import cz.covid.po.api.generated.dto.Address;
import cz.covid.po.api.generated.dto.PersonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonResponseConverter extends OneWayConverterBase<Person, PersonResponse> {
    private final CodebookConvertor codebookConvertor;

    @Override
    protected PersonResponse convertInternal(Person person) {
        PersonResponse result = new PersonResponse();

        result.setAddressHome(convertAddress(person.getAddress()));
        result.setEmail(person.getEmail());
        result.setFirstname(person.getFirstName());
        result.setSurname(person.getSurname());
        result.setReturnHash(person.getReturnHash());
        result.setHealthStatus(codebookConvertor.convert(person.getHealthStatus()));
        result.setPhoneNumber(person.getPhoneNumber());
        result.setPersonUid(person.getUid());

        if(person.getHealthStatusLastChange() != null){
            result.setHealthStatusLastChange(person.getHealthStatusLastChange().toLocalDate());
        }

        return result;
    }

    private Address convertAddress(cz.covid.po.api.domain.model.Address source) {
        if (source == null) {
            return null;
        }

        Address result = new Address();

        result.setCity(source.getCity());
        result.setStreet(source.getStreet());
        result.setStreetNumberDescriptive(source.getNumberDescriptive());
        result.setStreetNumberEvidence(source.getNumberEvidence());
        result.setZipCode(source.getZipCode());

        return result;
    }
}

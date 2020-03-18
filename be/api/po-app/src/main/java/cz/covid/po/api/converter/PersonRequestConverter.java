package cz.covid.po.api.converter;

import cz.covid.po.api.domain.model.Address;
import cz.covid.po.api.domain.model.Person;
import cz.covid.po.api.generated.dto.PersonRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonRequestConverter extends OneWayConverterBase<PersonRequest, Person> {
    @Override
    protected Person convertInternal(PersonRequest source) {
        Person result = new Person();

        result.setAddress(convertAddress(source.getAddressHome()));
        result.setEmail(source.getEmail());
        result.setFirstName(source.getFirstname());
        result.setSurname(source.getSurname());

        return result;
    }

    private Address convertAddress(cz.covid.po.api.generated.dto.Address source) {
        if (source == null) {
            return null;
        }

        Address result = new Address();

        result.setCity(source.getCity());
        result.setStreet(source.getStreet());
        result.setNumberDescriptive(source.getStreetNumberDescriptive());
        result.setNumberEvidence(source.getStreetNumberEvidence());
        result.setZipCode(source.getZipCode());

        return result;
    }
}

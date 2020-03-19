package cz.covid.po.api.controller;

import cz.covid.po.api.bl.service.PersonService;
import cz.covid.po.api.converter.PersonRequestConverter;
import cz.covid.po.api.converter.PersonResponseConverter;
import cz.covid.po.api.domain.model.Person;
import cz.covid.po.api.generated.controller.PersonControllerApi;
import cz.covid.po.api.generated.dto.PersonRequest;
import cz.covid.po.api.generated.dto.PersonResponse;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PersonController extends ControllerBase implements PersonControllerApi {

    private final PersonService personService;
    private final PersonRequestConverter personRequestConverter;
    private final PersonResponseConverter personResponseConverter;

    @Override
    public ResponseEntity<PersonResponse> getPerson(UUID personUid) {
        return ResponseEntity.ok(personResponseConverter.convert(personService.getByUid(personUid)));
    }

    @Override
    public ResponseEntity<PersonResponse> putPerson(UUID personUid, PersonRequest personDto) {
        Person source = personRequestConverter.convert(personDto);
        return ResponseEntity.ok(personResponseConverter.convert(personService.update(personUid, source)));
    }

    @Override
    public ResponseEntity<List<PersonResponse>> getAllPersons() {
        return ResponseEntity.ok(personResponseConverter.convert(personService.findAll()));
    }
}

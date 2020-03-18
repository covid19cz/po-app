package cz.covid.po.api.controller;

import cz.covid.po.api.bl.service.PersonService;
import cz.covid.po.api.domain.model.Person;
import cz.covid.po.api.generated.controller.AuthorizationControllerApi;
import cz.covid.po.api.generated.dto.SendCodeRequest;
import cz.covid.po.api.generated.dto.SendCodeResponse;
import cz.covid.po.api.generated.dto.VerifyCodeResponseDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthorizationController extends ControllerBase implements AuthorizationControllerApi {

    private final PersonService personService;

    @Override
    public ResponseEntity<SendCodeResponse> sendCodeUsingPOST(SendCodeRequest sendCodeRequest) {
        Person person = personService.getOrCreate(sendCodeRequest.getPhoneNumber());
        return ResponseEntity.ok(new SendCodeResponse().personUid(person.getUid()));
    }

    @Override
    public ResponseEntity<VerifyCodeResponseDto> verifyCodeUsingPOST(UUID personUid, String smsCode) {
        // temporary does nothing
        return ResponseEntity.ok(new VerifyCodeResponseDto());
    }
}
